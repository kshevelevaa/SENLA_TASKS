package service;

import dao.entity.Client;
import dao.entity.Maintenance;

import java.util.List;

public interface MaintenanceService extends AbstractService<Maintenance> {
    public int getMaintenancePriceForClient(long idClient);

    public List<Maintenance> sortServiceByPriceForClient(Client client);

    public List<Maintenance> sortServiceByDateForClient(Client client);

    public void importMaintenanceToFile(long id);

    public void exportMaintenanceFromFile(long id);
}
