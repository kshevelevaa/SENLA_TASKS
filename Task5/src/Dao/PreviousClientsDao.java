package Dao;

import Model.Client;

import java.util.ArrayList;
import java.util.List;

public class PreviousClientsDao {
    List<Client> previousClients = new ArrayList<>();

    public void addClient(Client client) {
        previousClients.add(client);
    }

    public List<Client> getPreviousClients() {
        return previousClients;
    }

    public void deleteClient(Client client) {
        previousClients.remove(client);

    }
}
