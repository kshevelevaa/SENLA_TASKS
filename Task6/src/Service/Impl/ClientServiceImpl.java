package Service.Impl;

import Dao.ClientDao;
import Dao.Entity.Client;
import Dao.Entity.ClientStatus;
import Dao.Entity.HotelRoom;
import Dao.Entity.Maintenance;
import Dao.HotelRoomDao;
import Dao.MaintenanceDao;
import Service.ClientService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ClientServiceImpl extends AbstractServiceImpl<Client, ClientDao> implements ClientService {
    private ClientDao clientDao;
    private MaintenanceDao maintenanceDao;
    private HotelRoomDao hotelRoomDao;


    public ClientServiceImpl(ClientDao clientDao, MaintenanceDao maintenanceDao, HotelRoomDao hotelRoomDao) {
        super(clientDao);
        this.clientDao = clientDao;
        this.maintenanceDao = maintenanceDao;
        this.hotelRoomDao = hotelRoomDao;
        setFile(new File("D:\\JavaCourse\\Task5\\src\\Dao\\Resources\\Client.csv"));

    }

    @Override
    public Client getById(long id) {
        return clientDao.getById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientDao.getAll();
    }

    @Override
    public void create(Client entity) {
        clientDao.create(entity);
    }

    @Override
    public void deleteById(long id) {
        clientDao.deleteById(id);
    }

    @Override
    public void updateById(long id, Client entity) {
        clientDao.updateById(id, entity);
    }

    @Override
    public long getCountOfClients() {
        return clientDao.getAll().stream().filter(x -> x.getClientStatus() == ClientStatus.CURRENT).count();
    }

    @Override
    public List<Client> getCurrentClients() {
        return clientDao.getAll().stream().filter((x -> x.getClientStatus() == ClientStatus.CURRENT)).toList();
    }

    @Override
    public int getTotalCostForClient(long idClient) {
        return clientDao.getTotalCost(getById(idClient));
    }

    public List<Client> sortClientsByAlphabet(List<Client> clients) {
        return clients.stream().sorted(Comparator.comparing(Client::getName)).toList();
    }

    @Override
    public List<Client> sortClientsByCheckOut(List<Client> clients) {
        return clients.stream().sorted(Comparator.comparing(Client::getCheckOut)).toList();
    }

    @Override
    public void addMaintenance(long idClient, long idMaintenance) {
        clientDao.getById(idClient).getMaintenances().add(maintenanceDao.getById(idMaintenance));
    }

    public void importClientToFile(long id) {
        Client client = getById(id);
        try {
            FileWriter fr = null;
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            sb.append(",");
            sb.append(client.getName());
            sb.append(",");
            sb.append(client.getHotelRoom().getId());
            sb.append(",");
            sb.append(client.getClientStatus());
            sb.append(",");
            sb.append(client.getCheckIn());
            sb.append(",");
            sb.append(client.getCheckOut());
            sb.append(",");
            sb.append(client.getDaysStaying());
            client.getMaintenances().size();
            for (Maintenance maintenance : client.getMaintenances()) {
                sb.append(",");
                sb.append(maintenance.getId());
            }
            sb.append("\n");

            fr = new FileWriter(getFile(), true);
            fr.write(sb.toString());
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void exportClientFromFile(long id) {
        try (Scanner scanner = new Scanner(getFile())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                long idClient = Integer.parseInt(words[0]);
                if (idClient == id) {
                    String name = words[1];
                    int idHotelRoom = Integer.parseInt(words[2]);
                    ClientStatus clientStatus = ClientStatus.valueOf(words[3]);
                    LocalDate checkIn = LocalDate.parse(words[4]);
                    LocalDate checkOut = LocalDate.parse(words[5]);
                    int dayStaying = Integer.parseInt(words[6]);
                    List<Maintenance> maintenances = new ArrayList<>();
                    for (int i = 7; i < words.length; i++) {
                        int idMaintenance = Integer.parseInt(words[i]);
                        maintenances.add(maintenanceDao.getById(idMaintenance));
                    }
                    Client client = new Client(name, dayStaying, checkIn);
                    client.setHotelRoom(hotelRoomDao.getById(idHotelRoom));
                    client.setClientStatus(clientStatus);
                    client.setCheckOut(checkOut);
                    client.setMaintenances(maintenances);
                    updateById(id, client);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
