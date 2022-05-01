import dao.entity.HotelRoom;
import dao.entity.Maintenance;
import dao.entity.RandomUtil;
import dao.impl.ClientDaoImpl;
import dao.impl.HotelRoomDaoImpl;
import dao.impl.MaintenanceDaoImpl;
import service.ClientService;
import service.impl.ClientServiceImpl;
import service.impl.HotelRoomServiceImpl;
import service.impl.MaintenanceServiceImpl;
import view.AbstractAction;
import view.Builder;
import view.MenuController;
import view.Navigator;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        HotelRoomDaoImpl hotelRoomDao = new HotelRoomDaoImpl();
        ClientDaoImpl clientDao = new ClientDaoImpl();
        MaintenanceDaoImpl maintenanceDao = new MaintenanceDaoImpl();

        ClientService clientService = new ClientServiceImpl(clientDao, maintenanceDao, hotelRoomDao);
        HotelRoomServiceImpl hotelRoomService = new HotelRoomServiceImpl(hotelRoomDao, clientDao);
        for (int i = 0; i < 10; i++) {
            HotelRoom hotelRoom = new HotelRoom(i, RandomUtil.getMax5(), RandomUtil.getMax5000(), RandomUtil.getMax5());
            hotelRoomService.create(hotelRoom);
        }

        MaintenanceServiceImpl maintenanceService = new MaintenanceServiceImpl(maintenanceDao, clientDao);
        maintenanceService.create(new Maintenance("платные телеканалы", 1300, LocalDateTime.now()));
        maintenanceService.create(new Maintenance("еда в номер", 500, LocalDateTime.now()));
        maintenanceService.create(new Maintenance("украшение номера к празднику", 1000, LocalDateTime.now()));

        AbstractAction.setClientService(clientService);
        AbstractAction.setHotelRoomService(hotelRoomService);
        AbstractAction.setMaintenanceService(maintenanceService);

        Builder builder=new Builder();
        MenuController menuController = new MenuController(builder, new Navigator(builder.getMenu()));
        menuController.run();

    }
}
