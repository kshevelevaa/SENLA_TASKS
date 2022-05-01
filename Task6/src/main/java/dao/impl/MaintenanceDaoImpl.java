package dao.impl;

import dao.MaintenanceDao;
import dao.entity.GenerateId;
import dao.entity.Maintenance;

public class MaintenanceDaoImpl extends AbstractDaoImpl<Maintenance> implements MaintenanceDao {

    static GenerateId generatorId = new GenerateId();

    @Override
    public void giveId(Maintenance entity) {
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
