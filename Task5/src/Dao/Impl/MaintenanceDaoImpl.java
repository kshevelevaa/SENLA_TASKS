package Dao.Impl;

import Dao.Entity.Maintenance;
import Dao.MaintenanceDao;

public class MaintenanceDaoImpl extends AbstractDaoImpl<Maintenance> implements MaintenanceDao {

    @Override
    public void updateById(long id, Maintenance newMaintenance) {
        Maintenance maintenance = getById(id);
        maintenance.setDate(newMaintenance.getDate());
        maintenance.setName(newMaintenance.getName());
        maintenance.setPrice(newMaintenance.getPrice());
    }
}
