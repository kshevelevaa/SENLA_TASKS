package Service;

import Dao.Entity.Client;
import Dao.Entity.Maintenance;

public interface MaintenanceService extends AbstractService<Maintenance> {
    public int getMaintenancePriceForClient(Client client);
}
