package dao.impl;

import dao.HotelRoomDao;
import dao.entity.GenerateId;
import dao.entity.HotelRoom;
import dao.entity.RoomStatus;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class HotelRoomDaoImpl extends AbstractDaoImpl<HotelRoom> implements HotelRoomDao {

    static GenerateId generatorId = new GenerateId();

    public void setMaxIdFromJson() {
        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream("D:\\JavaCourse\\Task6\\src\\main\\resources\\lastHotelRoomId.txt"), "UTF-8");
            BufferedReader reader = new BufferedReader(fr);
            String maxId = reader.readLine();
            long id = Long.parseLong(maxId);
            generatorId.setId(id);
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void giveId(HotelRoom entity) {
        entity.setId(generatorId.generateId());
    }

    @Override
    public void updateById(long id, HotelRoom newHotelRoom) {
        HotelRoom hotelRoom = getById(id);
        hotelRoom.setStatus(newHotelRoom.getStatus());
        hotelRoom.setDayPrice(newHotelRoom.getDayPrice());
        hotelRoom.setClientsInRoom(newHotelRoom.getClientsInRoom());
        hotelRoom.setRoomNumber(newHotelRoom.getRoomNumber());
        hotelRoom.setMaxPeopleCount(newHotelRoom.getMaxPeopleCount());
        hotelRoom.setPreviousClients(newHotelRoom.getPreviousClients());
        hotelRoom.setStarsCount(newHotelRoom.getStarsCount());
    }

    @Override
    public void changePriceOfHotelRoomById(int price, long idHotelRoom) {
        getById(idHotelRoom).setDayPrice(price);
    }

    @Override
    public void changeStatusOfHotelRoom(RoomStatus status, long idHotelRoom) {
        getById(idHotelRoom).setStatus(status);
    }

}
