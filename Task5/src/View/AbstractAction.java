package View;

import Dao.Impl.ClientDaoImpl;
import Dao.Impl.HotelRoomDaoImpl;
import Dao.Impl.MaintenanceDaoImpl;
import Service.ClientService;
import Service.Impl.ClientServiceImpl;
import Service.Impl.HotelRoomServiceImpl;
import Service.Impl.MaintenanceServiceImpl;

import java.util.Scanner;

public abstract class AbstractAction {

    protected Scanner scanner = new Scanner(System.in);

    static protected ClientService clientService;
    static protected HotelRoomServiceImpl hotelRoomService;
    static protected MaintenanceServiceImpl maintenanceService;

    public static ClientService getClientService() {
        return clientService;
    }

    public static void setClientService(ClientService clientService) {
        AbstractAction.clientService = clientService;
    }

    public static HotelRoomServiceImpl getHotelRoomService() {
        return hotelRoomService;
    }

    public static void setHotelRoomService(HotelRoomServiceImpl hotelRoomService) {
        AbstractAction.hotelRoomService = hotelRoomService;
    }

    public static MaintenanceServiceImpl getMaintenanceService() {
        return maintenanceService;
    }

    public static void setMaintenanceService(MaintenanceServiceImpl maintenanceService) {
        AbstractAction.maintenanceService = maintenanceService;
    }

    public abstract void doAction();
}
