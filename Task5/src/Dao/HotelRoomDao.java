package Dao;

import Dao.Entity.HotelRoom;
import Dao.Entity.RoomStatus;

public interface HotelRoomDao extends AbstractDao<HotelRoom> {

    public void changePriceOfHotelRoomById(int price, long idHotelRoom);

    public void changeStatusOfHotelRoom(RoomStatus status, long idHotelRoom);
}
