import Dao.Entity.HotelRoom;
import Dao.Entity.Maintenance;
import Dao.Entity.RandomUtil;
import Dao.Impl.ClientDaoImpl;
import Dao.Impl.HotelRoomDaoImpl;
import Dao.Impl.MaintenanceDaoImpl;
import Service.ClientService;
import Service.Impl.ClientServiceImpl;
import Service.Impl.HotelRoomServiceImpl;
import Service.Impl.MaintenanceServiceImpl;
import View.AbstractAction;
import View.MenuController;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        HotelRoomDaoImpl hotelRoomDao = new HotelRoomDaoImpl();
        ClientDaoImpl clientDao = new ClientDaoImpl();
        MaintenanceDaoImpl maintenanceDao = new MaintenanceDaoImpl();

        ClientService clientService = new ClientServiceImpl(clientDao, maintenanceDao);
        HotelRoomServiceImpl hotelRoomService = new HotelRoomServiceImpl(hotelRoomDao, clientDao);
        for (int i = 0; i < 10; i++) {
            HotelRoom hotelRoom=new HotelRoom(i, RandomUtil.getMax5(), RandomUtil.getMax5000(), RandomUtil.getMax5());
            hotelRoomService.create(hotelRoom);
        }

        MaintenanceServiceImpl maintenanceService = new MaintenanceServiceImpl(maintenanceDao, clientDao);
        maintenanceService.create(new Maintenance("платные телеканалы", 1300, LocalDateTime.now()));
        maintenanceService.create(new Maintenance("еда в номер", 500, LocalDateTime.now()));
        maintenanceService.create(new Maintenance("украшение номера к празднику", 1000, LocalDateTime.now()));

        AbstractAction.setClientService(clientService);
        AbstractAction.setHotelRoomService(hotelRoomService);
        AbstractAction.setMaintenanceService(maintenanceService);

        MenuController menuController = new MenuController();
        menuController.run();

    }
}
