package service;

import dao.entity.Client;
import dao.entity.HotelRoom;
import dao.HotelRoomDao;

import java.time.LocalDateTime;
import java.util.List;

public interface HotelRoomService extends AbstractService<HotelRoom>, HotelRoomDao {
    public void settle(List<Client> clients);

    public void evict(List<Client> clients);

    public long getCountOfFreeHotelRooms();

    public String getDetailOfHotelRoom(HotelRoom hotelRoom);

    public void getHotelRoomFreeOnData(LocalDateTime date);

    public HotelRoom findFreeRoom(List<Client> clients);

    public List<Client> PrintPreviousClientsInHotelRoom(long id);

    public List<HotelRoom> sortFreeHotelRoomsByPrice(List<HotelRoom> hotel);

    public List<HotelRoom> sortFreeHotelRoomsByCountOfPeople(List<HotelRoom> hotel);

    public List<HotelRoom> sortFreeHotelRoomsByCountOfStars(List<HotelRoom> hotel);

    public List<HotelRoom> sortHotelRoomsByPrice(List<HotelRoom> hotel);

    public List<HotelRoom> sortHotelRoomsByCountOfPeople(List<HotelRoom> hotel);

    public List<HotelRoom> sortHotelRoomsByCountOfStars(List<HotelRoom> hotel);

    public List<Client> getPreviousClientsWithNeedCount(long id, int count);

}
