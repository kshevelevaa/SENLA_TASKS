package Dao.Impl;

import Dao.Entity.Client;
import Dao.Entity.HotelRoom;
import Dao.Entity.RandomUtil;
import Dao.Entity.RoomStatus;
import Dao.HotelRoomDao;

import java.util.ArrayList;
import java.util.List;

public class HotelRoomDaoImpl extends AbstractDaoImpl<HotelRoom> implements HotelRoomDao {

    public HotelRoomDaoImpl() {
        for (int i = 0; i < 10; i++) {
            super.repository.add(new HotelRoom(i, RandomUtil.getMax5(), RandomUtil.getMax5000(), RandomUtil.getMax5()));
        }
    }

    @Override
    public void updateById(long id, HotelRoom hotelRoom) {
    }

    @Override
    public void addHotelRoom(HotelRoom hotelRoom) {
        repository.add(hotelRoom);
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
