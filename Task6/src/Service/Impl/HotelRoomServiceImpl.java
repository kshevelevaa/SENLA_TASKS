package Service.Impl;

import Dao.ClientDao;
import Dao.Entity.*;
import Dao.HotelRoomDao;
import Dao.Impl.ClientDaoImpl;
import Dao.Impl.HotelRoomDaoImpl;
import Service.HotelRoomService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HotelRoomServiceImpl extends AbstractServiceImpl<HotelRoom, HotelRoomDao> implements HotelRoomService {
    private HotelRoomDao hotelRoomDao;
    private ClientDao clientDao;
    //File hotelRoomFile = new File("D:\\JavaCourse\\Task5\\src\\Dao\\Resources\\HotelRoom.csv");


    public HotelRoomServiceImpl(HotelRoomDaoImpl hotelRoomDaoImpl, ClientDaoImpl clientDao) {
        super(hotelRoomDaoImpl);
        this.hotelRoomDao = hotelRoomDaoImpl;
        this.clientDao = clientDao;
        setFile(new File("D:\\JavaCourse\\Task5\\src\\Dao\\Resources\\HotelRoom.csv"));
    }

    @Override
    public void settle(List<Client> clients) {
        HotelRoom freeRoom = findFreeRoom(clients);
        if (freeRoom != null) {
            freeRoom.setClientsInRoom(clients);
            freeRoom.setStatus(RoomStatus.BUSY);
            for (Client client : clients) {
                client.setHotelRoom(freeRoom);
                clientDao.create(client);
            }
        }
    }

    @Override
    public void evict(List<Client> clients) {
        HotelRoom hotelRoom = clients.get(0).getHotelRoom();
        hotelRoom.setStatus(RoomStatus.FREE);
        hotelRoom.setClientsInRoom(null);
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).setClientStatus(ClientStatus.PREVIOUS);
            hotelRoom.getPreviousClients().add(clients.get(i));
        }
    }


    @Override
    public long getCountOfFreeHotelRooms() {
        return getAll().stream().filter(x -> x.getStatus() == RoomStatus.FREE).count();
    }

    @Override
    public String getDetailOfHotelRoom(HotelRoom hotelRoom) {
        return null;
    }

    @Override
    public void getHotelRoomFreeOnData(LocalDateTime date) {
        List<HotelRoom> hotelRooms = hotelRoomDao.getAll();
        for (HotelRoom hotelRoom : hotelRooms) {
            if (hotelRoom.getStatus() == RoomStatus.FREE) System.out.println(hotelRoom);
            if (hotelRoom.getStatus() == RoomStatus.BUSY) {
                long difference = ChronoUnit.DAYS.between(hotelRoom.getClientsInRoom().get(0).getCheckOut(), date);
                if (difference > 0) System.out.println(hotelRoom);
            }
        }
    }

    @Override
    public HotelRoom findFreeRoom(List<Client> clients) {
        List<HotelRoom> hotelRooms = hotelRoomDao.getAll();
        for (HotelRoom hotelRoom : hotelRooms) {
            if (hotelRoom.getMaxPeopleCount() >= clients.size() &&
                    hotelRoom.getStatus() == RoomStatus.FREE) {
                return hotelRoom;
            }
        }
        return null;
    }

    @Override
    public List<Client> PrintPreviousClientsInHotelRoom(long idHotelRoom) {
        HotelRoom hotelRoom = hotelRoomDao.getById(idHotelRoom);
        return hotelRoom.getPreviousClients();
    }

    @Override
    public void changePriceOfHotelRoomById(int price, long idHotelRoom) {
        hotelRoomDao.getById(idHotelRoom).setDayPrice(price);
    }

    @Override
    public void changeStatusOfHotelRoom(RoomStatus status, long idHotelRoom) {
        hotelRoomDao.getById(idHotelRoom).setStatus(status);
    }

    @Override
    public List<HotelRoom> sortFreeHotelRoomsByPrice(List<HotelRoom> hotel) {
        return hotel.stream().filter(x -> x.getStatus() == RoomStatus.FREE).sorted(Comparator.comparingInt(HotelRoom::getDayPrice)).toList();
    }

    @Override
    public List<HotelRoom> sortFreeHotelRoomsByCountOfPeople(List<HotelRoom> hotel) {
        return hotel.stream().filter(x -> x.getStatus() == RoomStatus.FREE).sorted(Comparator.comparingInt(HotelRoom::getMaxPeopleCount)).toList();
    }

    @Override
    public List<HotelRoom> sortFreeHotelRoomsByCountOfStars(List<HotelRoom> hotel) {
        return hotel.stream().filter(x -> x.getStatus() == RoomStatus.FREE).sorted(Comparator.comparingInt(HotelRoom::getStarsCount)).toList();
    }

    @Override
    public List<HotelRoom> sortHotelRoomsByPrice(List<HotelRoom> hotel) {
        return hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getDayPrice)).toList();
    }


    @Override
    public List<HotelRoom> sortHotelRoomsByCountOfPeople(List<HotelRoom> hotel) {
        return hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getMaxPeopleCount)).toList();
    }


    @Override
    public List<HotelRoom> sortHotelRoomsByCountOfStars(List<HotelRoom> hotel) {
        return hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getStarsCount)).toList();
    }

    @Override
    public void importHotelRoomToFile(long id) {
        HotelRoom hotelRoom = getById(id);
        try {
            FileWriter fr = null;
            StringBuilder sb = new StringBuilder();
            sb.append(id);
            for (int i = 0; i < 5; i++) {//max count of people in the room is 5
                sb.append(",");
                if (i < hotelRoom.getClientsInRoom().size()) {
                    sb.append(hotelRoom.getClientsInRoom().get(i).getId());
                } else {
                    sb.append("-1");
                }
            }
            sb.append(",");
            sb.append(hotelRoom.getDayPrice());
            sb.append(",");
            sb.append(hotelRoom.getStatus());
            sb.append(",");
            sb.append(hotelRoom.getRoomNumber());
            sb.append(",");
            sb.append(hotelRoom.getMaxPeopleCount());
            sb.append(",");
            sb.append(hotelRoom.getStarsCount());
            for (Client client : hotelRoom.getPreviousClients()) {
                sb.append(",");
                sb.append(client.getId());
            }
            sb.append("\n");

            fr = new FileWriter(getFile(), true);
            fr.write(sb.toString());
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exportHotelRoomFromFile(long id) {
        try (Scanner scanner = new Scanner(getFile())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                long idClient = Integer.parseInt(words[0]);
                if (idClient == id) {
                    List<Client> clientsInRoom = new ArrayList<>();
                    for (int i = 1; i < 6; i++) {
                        long idClientInRoom = Integer.parseInt(words[i]);
                        if (idClientInRoom != -1) clientsInRoom.add(clientDao.getById(idClientInRoom));
                    }
                    int dayPrice = Integer.parseInt(words[6]);
                    RoomStatus roomStatus = RoomStatus.valueOf(words[7]);
                    int roomNumber = Integer.parseInt(words[8]);
                    int maxPeopleCount = Integer.parseInt(words[9]);
                    int starsCount = Integer.parseInt(words[10]);
                    List<Client> previousClients = new ArrayList<>();
                    for (int i = 11; i < words.length; i++) {
                        long idPreviousClient = Integer.parseInt(words[i]);
                        previousClients.add(clientDao.getById(idPreviousClient));
                    }
                    HotelRoom hotelRoom = new HotelRoom(roomNumber, maxPeopleCount, dayPrice, starsCount);
                    hotelRoom.setStatus(roomStatus);
                    hotelRoom.setClientsInRoom(clientsInRoom);
                    hotelRoom.setPreviousClients(previousClients);
                    updateById(id, hotelRoom);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
