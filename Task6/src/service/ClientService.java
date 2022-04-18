package service;

import dao.entity.Client;

import java.util.List;

public interface ClientService extends AbstractService<Client> {
    public long getCountOfClients();

    public List<Client> getCurrentClients();

    public int getTotalCostForClient(long idClient);

    public List<Client> sortClientsByAlphabet(List<Client> clients);

    public List<Client> sortClientsByCheckOut(List<Client> clients);

    public void addMaintenance(long idClient, long idMaintenance);

    public void importClientToFile(long id);

    public void exportClientFromFile(long id);

}
