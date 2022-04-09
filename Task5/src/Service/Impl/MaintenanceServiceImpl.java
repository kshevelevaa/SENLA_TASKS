package Service.Impl;

import Dao.Entity.Client;
import Dao.Entity.Maintenance;
import Dao.MaintenanceDao;
import Service.MaintenanceService;

import java.util.Comparator;
import java.util.List;

public class MaintenanceServiceImpl extends AbstractServiceImpl<Maintenance, MaintenanceDao> implements MaintenanceService {
    private MaintenanceDao maintenanceDao;

    public MaintenanceServiceImpl(MaintenanceDao maintenanceDao) {
        super(maintenanceDao);
        this.maintenanceDao = maintenanceDao;
    }

    @Override
    public int getMaintenancePriceForClient(Client client) {
        return 0;
    }

    public List<Maintenance> sortServiceByPriceForClient(Client client) {
        List<Maintenance> service = client.getMaintenances();
        return service.stream().sorted(Comparator.comparing(Maintenance::getPrice)).toList();
    }

    public List<Maintenance> sortServiceByDateForClient(Client client) {
        List<Maintenance> service = client.getMaintenances();
        return service.stream().sorted(Comparator.comparing(Maintenance::getDate)).toList();
    }
}


