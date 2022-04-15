package Dao.Impl;

import Dao.Entity.Client;
import Dao.Entity.GenerateId;
import Dao.Entity.HotelRoom;
import Dao.Entity.RoomStatus;
import Dao.HotelRoomDao;

public class HotelRoomDaoImpl extends AbstractDaoImpl<HotelRoom> implements HotelRoomDao {

    static GenerateId generatorId=new GenerateId();

    public void giveId(HotelRoom entity){
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
