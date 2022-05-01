package service.impl;

import dao.ClientDao;
import dao.entity.Client;
import dao.entity.Maintenance;
import dao.MaintenanceDao;
import service.MaintenanceService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaintenanceServiceImpl extends AbstractServiceImpl<Maintenance, MaintenanceDao> implements MaintenanceService {
    private final MaintenanceDao maintenanceDao;
    private final ClientDao clientDao;

    public MaintenanceServiceImpl(MaintenanceDao maintenanceDao, ClientDao clientDao) {
        super(maintenanceDao);
        this.maintenanceDao = maintenanceDao;
        this.clientDao = clientDao;
        setFile(new File("D:\\JavaCourse\\Task6\\src\\Dao\\Resources\\Maintenance.csv"));
    }

    @Override
    public int getMaintenancePriceForClient(long idClient) {
        List<Maintenance> maintenances = clientDao.getById(idClient).getMaintenances();
        int maintenancePrice = 0;
        for (Maintenance maintenance : maintenances) {
            maintenancePrice += maintenance.getPrice();
        }
        return maintenancePrice;
    }

    @Override
    public List<Maintenance> sortServiceByPriceForClient(Client client) {
        List<Maintenance> service = client.getMaintenances();
        return service.stream().sorted(Comparator.comparing(Maintenance::getPrice)).toList();
    }
    @Override
    public List<Maintenance> sortServiceByDateForClient(Client client) {
        List<Maintenance> service = client.getMaintenances();
        return service.stream().sorted(Comparator.comparing(Maintenance::getDate)).toList();
    }

    @Override
    public void importToFile(long id) {
        Maintenance maintenance = getById(id);
        try {
            FileWriter fr = null;
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            sb.append(",");
            sb.append(maintenance.getName());
            sb.append(",");
            sb.append(maintenance.getPrice());
            sb.append(",");
            sb.append(maintenance.getDate());
            sb.append("\n");

            //fr = new FileWriter(maintenanceFile, true);
            fr = new FileWriter(getFile(), true);
            fr.write(sb.toString());
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exportFromFile(long id) {
        try (Scanner scanner = new Scanner(getFile())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                long idMaintenance = Integer.parseInt(words[0]);
                if (idMaintenance == id) {
                    String name = words[1];
                    int price = Integer.parseInt(words[2]);
                    LocalDateTime date = LocalDateTime.parse(words[3]);
                    Maintenance maintenance = new Maintenance(name, price, date);
                    updateById(id, maintenance);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


