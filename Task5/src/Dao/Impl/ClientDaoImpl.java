package Dao.Impl;

import Dao.ClientDao;
import Dao.Entity.Client;

public class ClientDaoImpl extends AbstractDaoImpl<Client> implements ClientDao {


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
