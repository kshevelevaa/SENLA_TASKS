package dao;

import dao.entity.HotelRoom;
import dao.entity.RoomStatus;

public interface HotelRoomDao extends AbstractDao<HotelRoom> {

    public void changePriceOfHotelRoomById(int price, long idHotelRoom);

    public void changeStatusOfHotelRoom(RoomStatus status, long idHotelRoom);
}
