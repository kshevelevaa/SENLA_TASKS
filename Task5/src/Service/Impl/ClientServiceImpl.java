package Service.Impl;

import Dao.ClientDao;
import Dao.Entity.Client;
import Dao.Entity.ClientStatus;
import Dao.Entity.Maintenance;
import Dao.MaintenanceDao;
import Service.ClientService;

import java.util.Comparator;
import java.util.List;

public class ClientServiceImpl extends AbstractServiceImpl<Client, ClientDao> implements ClientService {
    private ClientDao clientDao;
    private MaintenanceDao maintenanceDao;

    public ClientServiceImpl(ClientDao clientDao, MaintenanceDao maintenanceDao) {
        super(clientDao);
        this.clientDao = clientDao;
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    public Client getById(long id) {
        return clientDao.getById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientDao.getAll();
    }

    @Override
    public void create(Client entity) {
        clientDao.create(entity);
    }

    @Override
    public void deleteById(long id) {
        clientDao.deleteById(id);
    }

    @Override
    public void updateById(long id, Client entity) {
        clientDao.updateById(id, entity);
    }

    @Override
    public long getCountOfClients() {
        return clientDao.getAll().stream().filter(x -> x.getClientStatus() == ClientStatus.CURRENT).count();
    }

    @Override
    public List<Client> getCurrentClients() {
        return clientDao.getAll().stream().filter((x -> x.getClientStatus() == ClientStatus.CURRENT)).toList();
    }

    @Override
    public int getTotalCostForClient(long idClient) {
        return clientDao.getTotalCost(getById(idClient));
    }

    public List<Client> sortClientsByAlphabet(List<Client> clients) {
        return clients.stream().sorted(Comparator.comparing(Client::getName)).toList();
    }

    public List<Client> sortClientsByCheckOut(List<Client> clients) {
        return clients.stream().sorted(Comparator.comparing(Client::getCheckOut)).toList();
    }

    @Override
    public void addMaintenance(long idClient, long idMaintenance) {
        clientDao.getById(idClient).getMaintenances().add(maintenanceDao.getById(idMaintenance));
    }

}
