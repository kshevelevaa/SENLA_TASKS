package Service;

import Dao.Entity.Client;
import Dao.Entity.Maintenance;

import java.util.List;

public interface ClientService extends AbstractService<Client> {
    public long getCountOfClients();

    public List<Client> getCurrentClients();

    public int getTotalCostForClient(Client client);

    public void sortClientsByAlphabet(List<Client> clients);

    public void sortClientsByCheckOut(List<Client> clients);

    public void addMaintenance(Client client, Maintenance maintenance);

}
