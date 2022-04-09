package Dao;

import Dao.Entity.Client;
import Dao.Entity.Maintenance;

public interface ClientDao extends AbstractDao<Client> {
    public void addClient(Client client);
}
