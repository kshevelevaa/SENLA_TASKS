package view.implAction;

import dao.entity.RoomStatus;
import view.AbstractAction;
import view.ReadUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ChangeStatusOfHotelRoomOnRepair extends AbstractAction {
    public static final String PATH_TO_PROPERTIES = "src/resources/app.properties";

    @Override
    public void doAction() {
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            String isHotelRoomStatusChange = prop.getProperty("isHotelRoomStatusChange");
            if (isHotelRoomStatusChange != "yes") {
                System.out.println("измените настройки конфигурации и перезапустите программу, чтобы выполнить действие\n");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long idHotelRoom = ReadUtil.readId(hotelRoomService);
        hotelRoomService.changeStatusOfHotelRoom(RoomStatus.REPAIR, idHotelRoom);
        System.out.println("статус номера изменен на " + hotelRoomService.getById(idHotelRoom).getStatus());
    }
}
