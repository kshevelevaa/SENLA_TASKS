package dao.impl;

import dao.MaintenanceDao;
import dao.entity.GenerateId;
import dao.entity.Maintenance;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MaintenanceDaoImpl extends AbstractDaoImpl<Maintenance> implements MaintenanceDao {

    static GenerateId generatorId = new GenerateId();

    public void setMaxIdFromJson() {
        try {
            InputStreamReader fr = new InputStreamReader(new FileInputStream("D:\\JavaCourse\\Task6\\src\\main\\resources\\lastMaintenanceId.txt"), "UTF-8");
            BufferedReader reader = new BufferedReader(fr);
            String maxId = reader.readLine();
            long id = Long.parseLong(maxId);
            this.generatorId.setId(id);
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
