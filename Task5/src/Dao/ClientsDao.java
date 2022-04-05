package Dao;

import Model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientsDao {
    List<Client> currentClients = new ArrayList<>();

    public void addClient(Client client) {
        currentClients.add(client);
    }

    public List<Client> getCurrentClients() {
        return currentClients;
    }

    public void deleteClient(Client client) {
        currentClients.remove(client);
    }


}
