package Service.Impl;

import Dao.ClientDao;
import Dao.Entity.Client;
import Dao.Entity.Maintenance;
import Dao.MaintenanceDao;
import Service.MaintenanceService;

import java.util.Comparator;
import java.util.List;

public class MaintenanceServiceImpl extends AbstractServiceImpl<Maintenance, MaintenanceDao> implements MaintenanceService {
    private MaintenanceDao maintenanceDao;
    private ClientDao clientDao;

    public MaintenanceServiceImpl(MaintenanceDao maintenanceDao, ClientDao clientDao) {
        super(maintenanceDao);
        this.maintenanceDao = maintenanceDao;
        this.clientDao=clientDao;
    }

    @Override
    public int getMaintenancePriceForClient(long idClient) {
        List<Maintenance> maintenances=clientDao.getById(idClient).getMaintenances();
        int maintenancePrice=0;
        for (Maintenance maintenance: maintenances){
            maintenancePrice+=maintenance.getPrice();
        }
        return maintenancePrice;
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


