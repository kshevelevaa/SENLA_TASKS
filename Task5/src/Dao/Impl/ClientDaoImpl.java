package Dao.Impl;

import Dao.ClientDao;
import Dao.Entity.Client;
import Dao.Entity.Maintenance;

public class ClientDaoImpl extends AbstractDaoImpl<Client> implements ClientDao {

    public ClientDaoImpl() {
        super();
    }

    @Override
    public void updateById(long id, Client client) {

    }

    @Override
    public void addClient(Client client) {
        super.repository.add(client);
    }

}
