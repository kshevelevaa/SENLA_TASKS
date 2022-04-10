package Service.Impl;

import Dao.ClientDao;
import Dao.Entity.Client;
import Dao.Entity.ClientStatus;
import Dao.Entity.Maintenance;
import Service.ClientService;

import java.util.Comparator;
import java.util.List;

public class ClientServiceImpl extends AbstractServiceImpl<Client, ClientDao> implements ClientService {
    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao) {
        super(clientDao);
        this.clientDao = clientDao;
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
    public int getTotalCostForClient(Client client) {
        return clientDao.getTotalCost(client);
    }

    public void sortClientsByAlphabet(List<Client> clients) {
        clients.stream().sorted(Comparator.comparing(Client::getName)).forEach(System.out::println);
    }

    public void sortClientsByCheckOut(List<Client> clients) {
        clients.stream().sorted(Comparator.comparing(Client::getCheckOut)).forEach(System.out::println);
    }

    @Override
    public void addMaintenance(Client client, Maintenance maintenance) {
        client.getMaintenances().add(maintenance);
    }

}
