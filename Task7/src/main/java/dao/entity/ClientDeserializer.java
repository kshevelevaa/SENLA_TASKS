package dao.entity;


import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientDeserializer extends StdDeserializer<Client> {
    public ClientDeserializer() {
        this(null);
    }

    protected ClientDeserializer(Class<?> vc) {
        super((vc));
    }

    public Client deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        long id = node.get("id").asLong();
        String name = node.get("name").textValue();
        HotelRoom hotelRoom = StaticDao.getHotelRoomDao().getById(node.get("hotelRoom").asLong());
        ClientStatus status = ClientStatus.valueOf(node.get("clientStatus").textValue());
        LocalDate checkIn = LocalDate.parse(node.get("checkInForJson").textValue());
        LocalDate checkOut = LocalDate.parse(node.get("checkOutForJson").textValue());
        int dayStaying = node.get("daysStaying").intValue();
        List<Maintenance> maintenances = new ArrayList<>();
        if (StaticDao.maintenanceDao.getById(node.get("maintenances").asLong()) != null) {
            maintenances.add(StaticDao.maintenanceDao.getById(node.get("maintenances").asLong()));
        }

        Client client = new Client();
        client.setId(id);
        client.setName(name);
        client.setHotelRoom(hotelRoom);
        if (hotelRoom != null && hotelRoom.getClientsInRoom() != null) {
            List<Client> clients = hotelRoom.getClientsInRoom();
            clients.add(client);
            hotelRoom.setClientsInRoom(clients);
        } else if (hotelRoom != null) {
            List<Client> clientsInRoom = new ArrayList<>();
            clientsInRoom.add(client);
            hotelRoom.setClientsInRoom(clientsInRoom);
        }
        client.setClientStatus(status);
        client.setCheckIn(checkIn);
        client.setCheckOut(checkOut);
        client.setDaysStaying(dayStaying);
        client.setMaintenances(maintenances);

        StaticDao.clientDao.create(client);
        return client;
    }
}
