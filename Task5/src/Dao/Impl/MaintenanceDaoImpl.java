package Dao.Impl;

import Dao.Entity.Client;
import Dao.Entity.GenerateId;
import Dao.Entity.Maintenance;
import Dao.MaintenanceDao;

public class MaintenanceDaoImpl extends AbstractDaoImpl<Maintenance> implements MaintenanceDao {

    static GenerateId generatorId=new GenerateId();

    public void giveId(Maintenance entity){
        entity.setId(generatorId.generateId());
    }
    @Override
    public void updateById(long id, Maintenance newMaintenance) {
        Maintenance maintenance = getById(id);
        maintenance.setDate(newMaintenance.getDate());
        maintenance.setName(newMaintenance.getName());
        maintenance.setPrice(newMaintenance.getPrice());
    }
}
