package Dao.Impl;

import Dao.Entity.HotelRoom;
import Dao.Entity.RoomStatus;
import Dao.HotelRoomDao;

public class HotelRoomDaoImpl extends AbstractDaoImpl<HotelRoom> implements HotelRoomDao {

    @Override
    public void updateById(long id, HotelRoom newHotelRoom) {
        HotelRoom hotelRoom = getById(id);
        hotelRoom.setStatus(newHotelRoom.getStatus());
        hotelRoom.setDayPrice(newHotelRoom.getDayPrice());
        hotelRoom.setClientsInRoom(newHotelRoom.getClientsInRoom());
        hotelRoom.setRoomNumber(newHotelRoom.getRoomNumber());
        hotelRoom.setMaxPeopleCount(newHotelRoom.getMaxPeopleCount());
    }

    @Override
    public void changePriceOfHotelRoomById(int price, HotelRoom hotelRoom) {
        hotelRoom.setDayPrice(price);
    }

    @Override
    public void changeStatusOfHotelRoom(RoomStatus status, HotelRoom hotelRoom) {
        hotelRoom.setStatus(status);
    }
}
