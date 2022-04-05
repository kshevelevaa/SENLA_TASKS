package Dao;

import Model.HotelRoom;

import java.util.ArrayList;
import java.util.List;

public class HotelRoomDaoImpl {
    protected List<HotelRoom> hotel = new ArrayList<>();
    int hotelSize = 0;

    public HotelRoomDaoImpl() {//create hotel
        for (int i = 0; i < 10; i++)
            hotel.add(new HotelRoom(hotelSize++));
    }

    public int getHotelSize() {
        return hotelSize;
    }

    public List<HotelRoom> getHotel() {
        return hotel;
    }

    public void addRoom() {
        System.out.println("Всего комнат: " + hotelSize);
        System.out.println("Добавили комнату ");
        hotel.add(new HotelRoom(hotelSize++));
        System.out.println("Всего комнат: " + hotelSize);
    }


}
