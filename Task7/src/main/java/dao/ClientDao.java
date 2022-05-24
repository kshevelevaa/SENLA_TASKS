package dao;

import dao.entity.Client;

public interface ClientDao extends AbstractDao<Client> {
    public int getTotalCost(Client client);
}
