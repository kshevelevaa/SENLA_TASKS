package Dao;

import Dao.Entity.Client;

public interface ClientDao extends AbstractDao<Client> {
    public int getTotalCost(Client client);
}
