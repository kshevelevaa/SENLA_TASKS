package Service;

import Dao.Entity.Client;
import Dao.Entity.HotelRoom;
import Dao.Entity.RoomStatus;
import Dao.HotelRoomDao;

import java.time.LocalDate;
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
}
