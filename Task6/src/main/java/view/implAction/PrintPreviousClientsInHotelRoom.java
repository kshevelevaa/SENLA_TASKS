package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PrintPreviousClientsInHotelRoom extends AbstractAction {

    public static final String PATH_TO_PROPERTIES = "src/resources/app.properties";

    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readId(hotelRoomService);
        FileInputStream fileInputStream;
        Properties prop = new Properties();
        int countOfPreviousClientInHotelRoom = 1;
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            prop.load(fileInputStream);
            countOfPreviousClientInHotelRoom = Integer.parseInt(prop.getProperty("countOfPreviousClientInHotelRoom"));
            System.out.println("по заданным настройкам требуется вывести " + countOfPreviousClientInHotelRoom
                    + "предыдущих клиентов\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (countOfPreviousClientInHotelRoom <= hotelRoomService.getById(idHotelRoom).getPreviousClients().size()) {
            System.out.println("предыдущие клиенты номера:\n" +
                    hotelRoomService.getPreviousClientsWithNeedCount(idHotelRoom, countOfPreviousClientInHotelRoom));
        } else {
            System.out.println("количество предыдущих клиентов в настройках превышает реальное количество предыдущих клиентов");
        }
    }
}
