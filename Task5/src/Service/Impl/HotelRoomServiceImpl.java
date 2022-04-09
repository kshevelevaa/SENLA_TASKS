package Service.Impl;

import Dao.ClientDao;
import Dao.Entity.Client;
import Dao.Entity.ClientStatus;
import Dao.Entity.HotelRoom;
import Dao.Entity.RoomStatus;
import Dao.HotelRoomDao;
import Dao.Impl.ClientDaoImpl;
import Dao.Impl.HotelRoomDaoImpl;
import Service.HotelRoomService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

public class HotelRoomServiceImpl extends AbstractServiceImpl<HotelRoom, HotelRoomDao> implements HotelRoomService {
    private HotelRoomDao hotelRoomDao;
    private ClientDao clientDao;

    public HotelRoomServiceImpl(HotelRoomDaoImpl hotelRoomDaoImpl, ClientDaoImpl clientDao) {
        super(hotelRoomDaoImpl);
        this.hotelRoomDao = hotelRoomDaoImpl;
        this.clientDao = clientDao;
    }

    @Override
    public void settle(List<Client> clients) {
        HotelRoom freeRoom = findFreeRoom(clients);
        if (freeRoom != null) {
            freeRoom.setClientsInRoom(clients);
            freeRoom.setStatus(RoomStatus.BUSY);
            for (Client client : clients) {
                client.setHotelRoom(freeRoom);
                clientDao.addClient(client);
            }
        }
    }

    @Override
    public void evict(List<Client> clients) {
        clients.get(0).getHotelRoom().setStatus(RoomStatus.FREE);
        clients.get(0).getHotelRoom().setClientsInRoom(null);
        for (int i = 0; i < clients.size(); i++) clients.get(i).setClientStatus(ClientStatus.PREVIOUS);
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
        for (int i = 0; i < hotelRoomDao.getAll().size(); i++) {
            HotelRoom hotelRoom = hotelRoomDao.getAll().get(i);
            if (hotelRoom.getStatus() == RoomStatus.FREE) System.out.println(hotelRoom);
            if (hotelRoom.getStatus() == RoomStatus.BUSY) {
                long difference = ChronoUnit.DAYS.between(hotelRoom.getClientsInRoom().get(0).getCheckOut(), date);
                if (difference > 0) System.out.println(hotelRoom);
            }
        }
    }

    @Override
    public HotelRoom findFreeRoom(List<Client> clients) {
        int i = 0;
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
    public List<Client> PrintPreviousClientsInHotelRoom(long id) {
        HotelRoom hotelRoom = hotelRoomDao.getById(id);
        return clientDao.getAll().stream().filter(x -> (x.getHotelRoom() == hotelRoom && x.getClientStatus() == ClientStatus.PREVIOUS)).toList();
    }

    @Override
    public void addHotelRoom(HotelRoom hotelRoom) {
        hotelRoomDao.addHotelRoom(hotelRoom);
    }

    @Override
    public void changePriceOfHotelRoomById(int price, HotelRoom hotelRoom) {
        hotelRoom.setDayPrice(price);
    }

    @Override
    public void changeStatusOfHotelRoom(RoomStatus status, HotelRoom hotelRoom) {
        hotelRoom.setStatus(status);
    }

    public List<HotelRoom> sortFreeHotelRoomsByPrice(List<HotelRoom> hotel) {
        return hotel.stream().filter(x -> x.getStatus() == RoomStatus.FREE).sorted(Comparator.comparingInt(HotelRoom::getDayPrice)).toList();
    }

    public List<HotelRoom> sortFreeHotelRoomsByCountOfPeople(List<HotelRoom> hotel) {
        return hotel.stream().filter(x -> x.getStatus() == RoomStatus.FREE).sorted(Comparator.comparingInt(HotelRoom::getMaxPeopleCount)).toList();
    }

    public List<HotelRoom> sortFreeHotelRoomsByCountOfStars(List<HotelRoom> hotel) {
        return hotel.stream().filter(x -> x.getStatus() == RoomStatus.FREE).sorted(Comparator.comparingInt(HotelRoom::getStarsCount)).toList();
    }

    public List<HotelRoom> sortHotelRoomsByPrice(List<HotelRoom> hotel) {
        return hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getDayPrice)).toList();
    }


    public List<HotelRoom> sortHotelRoomsByCountOfPeople(List<HotelRoom> hotel) {
        return hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getMaxPeopleCount)).toList();
    }


    public List<HotelRoom> sortHotelRoomsByCountOfStars(List<HotelRoom> hotel) {
        return hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getStarsCount)).toList();
    }

}
