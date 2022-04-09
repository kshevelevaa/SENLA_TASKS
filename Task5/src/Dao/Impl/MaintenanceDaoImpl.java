package Dao.Impl;

import Dao.Entity.HotelRoom;
import Dao.Entity.Maintenance;
import Dao.HotelRoomDao;
import Dao.MaintenanceDao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MaintenanceDaoImpl extends AbstractDaoImpl<Maintenance> implements MaintenanceDao {
    public MaintenanceDaoImpl() {
        super.repository.add(new Maintenance("платные телеканалы", 300, LocalDateTime.now()));
        super.repository.add(new Maintenance("еда в номер", 500, LocalDateTime.now()));
        super.repository.add(new Maintenance("украшение номера к празднику", 1000, LocalDateTime.now()));
    }

    @Override
    public void updateById(long id, Maintenance entity) {

    }
}
