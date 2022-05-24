package dao.impl;

import dao.ClientDao;
import dao.entity.Client;
import dao.entity.GenerateId;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ClientDaoImpl extends AbstractDaoImpl<Client> implements ClientDao {

    static GenerateId generatorId = new GenerateId();

    public void setMaxIdFromJson() {
        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream("D:\\JavaCourse\\Task6\\src\\main\\resources\\lastClientId.txt"), "UTF-8");
            BufferedReader reader = new BufferedReader(fr);
            String maxId = reader.readLine();
            long id = Long.parseLong(maxId);
            this.generatorId.setId(id);
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void giveId(Client entity) {
        entity.setId(generatorId.generateId());
    }

    @Override
    public void updateById(long id, Client newClient) {
        Client client = getById(id);
        client.setName(newClient.getName());
        client.setCheckIn(newClient.getCheckIn());
        client.setHotelRoom(newClient.getHotelRoom());
        client.setClientStatus(newClient.getClientStatus());
        client.setCheckOut(newClient.getCheckOut());
        client.setDaysStaying(newClient.getDaysStaying());
        client.setMaintenances(newClient.getMaintenances());
    }

    @Override
    public int getTotalCost(Client client) {
        int totalCost = 0;
        int maintenancePrice = 0;
        for (int i = 0; i < client.getMaintenances().size(); i++) {
            maintenancePrice += client.getMaintenances().get(i).getPrice();
        }
        totalCost = client.getDaysStaying() * client.getHotelRoom().getDayPrice() + maintenancePrice;
        return totalCost;
    }

}
