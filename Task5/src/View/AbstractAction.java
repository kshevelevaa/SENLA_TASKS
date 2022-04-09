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
    static protected HotelRoomDaoImpl hotelRoomDao = new HotelRoomDaoImpl();

    static protected ClientDaoImpl clientDao = new ClientDaoImpl();
    static protected ClientService clientService = new ClientServiceImpl(clientDao);
    static protected HotelRoomServiceImpl hotelRoomService = new HotelRoomServiceImpl(hotelRoomDao, clientDao);

    static protected MaintenanceDaoImpl maintenanceDao = new MaintenanceDaoImpl();
    static protected MaintenanceServiceImpl maintenanceService = new MaintenanceServiceImpl(maintenanceDao);

    public abstract void doAction();
}
