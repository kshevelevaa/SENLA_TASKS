import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import dao.entity.Client;
import dao.entity.HotelRoom;
import dao.entity.Maintenance;
import dao.entity.RandomUtil;
import dao.entity.StaticDao;
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

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        HotelRoomDaoImpl hotelRoomDao = new HotelRoomDaoImpl();
        ClientDaoImpl clientDao = new ClientDaoImpl();
        MaintenanceDaoImpl maintenanceDao = new MaintenanceDaoImpl();

        StaticDao.setClientDao(clientDao);
        StaticDao.setHotelRoomDao(hotelRoomDao);
        StaticDao.setMaintenanceDao(maintenanceDao);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        FileReader readerMaintenance = new FileReader("D:\\JavaCourse\\Task7\\src\\main\\resources\\maintenance.json");
        FileReader readerClient = new FileReader("D:\\JavaCourse\\Task7\\src\\main\\resources\\client.json");
        FileReader readerHotelRoom = new FileReader("D:\\JavaCourse\\Task7\\src\\main\\resources\\hotelRoom.json");

        CollectionType javaTypeMaintenance = mapper.getTypeFactory().constructCollectionType(List.class, Maintenance.class);
        CollectionType javaTypeClient = mapper.getTypeFactory().constructCollectionType(List.class, Client.class);
        CollectionType javaTypeHotelRoom = mapper.getTypeFactory().constructCollectionType(List.class, HotelRoom.class);

        maintenanceDao.addAll(mapper.readValue(readerMaintenance, javaTypeMaintenance));
        StaticDao.setMaintenanceDao(maintenanceDao);
        hotelRoomDao.addAll(mapper.readValue(readerHotelRoom, javaTypeHotelRoom));
        StaticDao.setHotelRoomDao(hotelRoomDao);
        clientDao.addAll(mapper.readValue(readerClient, javaTypeClient));
        StaticDao.setClientDao(clientDao);

        ClientService clientService = new ClientServiceImpl(clientDao, maintenanceDao, hotelRoomDao);
        HotelRoomServiceImpl hotelRoomService = new HotelRoomServiceImpl(hotelRoomDao, clientDao);
        if (hotelRoomDao.getAll().size() == 0) {
            for (int i = 0; i < 10; i++) {
                HotelRoom hotelRoom = new HotelRoom(i, RandomUtil.getMax5(), RandomUtil.getMax5000(), RandomUtil.getMax5());
                hotelRoomService.create(hotelRoom);
            }
        }
        MaintenanceServiceImpl maintenanceService = new MaintenanceServiceImpl(maintenanceDao, clientDao);
        if (maintenanceDao.getAll().size() == 0) {
            maintenanceService.create(new Maintenance("платные телеканалы", 1300, LocalDateTime.now()));
            maintenanceService.create(new Maintenance("еда в номер", 500, LocalDateTime.now()));
            maintenanceService.create(new Maintenance("украшение номера к празднику", 1000, LocalDateTime.now()));
        }

        AbstractAction.setClientService(clientService);
        AbstractAction.setHotelRoomService(hotelRoomService);
        AbstractAction.setMaintenanceService(maintenanceService);

        clientDao.setMaxIdFromJson();
        hotelRoomDao.setMaxIdFromJson();
        maintenanceDao.setMaxIdFromJson();

        Builder builder = new Builder();
        MenuController menuController = new MenuController(builder, new Navigator(builder.getMenu()));
        menuController.run();

        StringWriter writerMaintenance = new StringWriter();
        StringWriter writerClient = new StringWriter();
        StringWriter writerHotelRoom = new StringWriter();

        StaticDao.setHotelRoomDao(hotelRoomDao);
        StaticDao.setClientDao(clientDao);
        StaticDao.setMaintenanceDao(maintenanceDao);

        mapper.writeValue(writerMaintenance, StaticDao.getMaintenanceDao().getAll());
        mapper.writeValue(writerHotelRoom, StaticDao.getHotelRoomDao().getAll());
        mapper.writeValue(writerClient, StaticDao.getClientDao().getAll());

        try {
            FileWriter fileMaintenance = new FileWriter("D:\\JavaCourse\\Task7\\src\\main\\resources\\maintenance.json");
            FileWriter fileClient = new FileWriter("D:\\JavaCourse\\Task7\\src\\main\\resources\\client.json");
            FileWriter fileHotelRoom = new FileWriter("D:\\JavaCourse\\Task7\\src\\main\\resources\\hotelRoom.json");

            FileWriter lastClientId = new FileWriter("D:\\JavaCourse\\Task7\\src\\main\\resources\\lastClientId.txt");
            FileWriter lastHotelRoomId = new FileWriter("D:\\JavaCourse\\Task7\\src\\main\\resources\\lastHotelRoomId.txt");
            FileWriter lastMaintenanceId = new FileWriter("D:\\JavaCourse\\Task7\\src\\main\\resources\\lastMaintenanceId.txt");

            lastClientId.write(String.valueOf(clientDao.getById(clientDao.getAll().size()).getId()));
            lastHotelRoomId.write(String.valueOf(hotelRoomDao.getById(hotelRoomDao.getAll().size()).getId()));
            lastMaintenanceId.write(String.valueOf(maintenanceDao.getById(maintenanceDao.getAll().size()).getId()));

            fileMaintenance.write(writerMaintenance.toString());
            fileHotelRoom.write(writerHotelRoom.toString());
            fileClient.write(writerClient.toString());

            fileMaintenance.close();
            fileClient.close();
            fileHotelRoom.close();

            lastClientId.close();
            lastMaintenanceId.close();
            lastHotelRoomId.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

