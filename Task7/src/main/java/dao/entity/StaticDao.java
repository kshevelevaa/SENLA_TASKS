package dao.entity;

import dao.impl.ClientDaoImpl;
import dao.impl.HotelRoomDaoImpl;
import dao.impl.MaintenanceDaoImpl;

public  class StaticDao {
    static HotelRoomDaoImpl hotelRoomDao;
    static ClientDaoImpl clientDao;
    static MaintenanceDaoImpl maintenanceDao;
//    public StaticDao(HotelRoomDaoImpl hotelRoomDao, MaintenanceDaoImpl maintenanceDao, ClientDaoImpl clientDao){
//        this.clientDao = clientDao;
//        this.hotelRoomDao = hotelRoomDao;
//        System.out.println(hotelRoomDao.getAll());
//        this.maintenanceDao = maintenanceDao;
//    }

    public static HotelRoomDaoImpl getHotelRoomDao() {
        return hotelRoomDao;
    }

    public static void setHotelRoomDao(HotelRoomDaoImpl hotelRoomDao) {
        StaticDao.hotelRoomDao = hotelRoomDao;
    }

    public static ClientDaoImpl getClientDao() {
        return clientDao;
    }

    public static void setClientDao(ClientDaoImpl clientDao) {
        StaticDao.clientDao = clientDao;
    }

    public static MaintenanceDaoImpl getMaintenanceDao() {
        return maintenanceDao;
    }

    public static void setMaintenanceDao(MaintenanceDaoImpl maintenanceDao) {
        StaticDao.maintenanceDao = maintenanceDao;
    }
}
