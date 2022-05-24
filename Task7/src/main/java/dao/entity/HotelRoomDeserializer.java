package dao.entity;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HotelRoomDeserializer extends StdDeserializer<HotelRoom> {
    public HotelRoomDeserializer() {
        this(null);
    }

    protected HotelRoomDeserializer(Class<?> vc) {
        super((vc));
    }

    public HotelRoom deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        long id = node.get("id").asLong();
        int dayPrice = node.get("dayPrice").intValue();
        RoomStatus status = RoomStatus.valueOf(node.get("status").textValue());
        int roomNumber = node.get("roomNumber").intValue();
        int maxPeopleCount = node.get("maxPeopleCount").intValue();
        int starsCount = node.get("starsCount").intValue();
        List<Client> clientsInRoom = new ArrayList<>();
        if (StaticDao.getClientDao() != null && StaticDao.clientDao.getById(node.get("clientsInRoom").asLong()) != null) {
            clientsInRoom.add(StaticDao.clientDao.getById(node.get("clientsInRoom").asLong()));
        }
        List<Client> previousClients = new ArrayList<>();
        if (StaticDao.getClientDao() != null && StaticDao.clientDao.getById(node.get("previousClients").asLong()) != null) {
            previousClients.add(StaticDao.clientDao.getById(node.get("previousClients").asLong()));
        }
        HotelRoom hotelRoom = new HotelRoom(roomNumber, maxPeopleCount, dayPrice, starsCount);
        hotelRoom.setClientsInRoom(clientsInRoom);
        hotelRoom.setStatus(status);
        hotelRoom.setPreviousClients(previousClients);
        if (StaticDao.getClientDao() != null && StaticDao.clientDao.getById(node.get("previousClients").asLong()) != null) {
            StaticDao.clientDao.getById(node.get("previousClients").asLong()).setHotelRoom(hotelRoom);
        }

        if (StaticDao.hotelRoomDao.getById(id) != null)
            StaticDao.hotelRoomDao.updateById(id, hotelRoom);
        else
            StaticDao.hotelRoomDao.create(hotelRoom);
        return hotelRoom;
    }
}
