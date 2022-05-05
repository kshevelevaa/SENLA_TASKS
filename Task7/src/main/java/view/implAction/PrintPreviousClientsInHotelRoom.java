package view.implAction;

import view.AbstractAction;
import view.ConfigUtil;
import view.ReadUtil;

public class PrintPreviousClientsInHotelRoom extends AbstractAction {

    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readId(hotelRoomService);
        int countOfPreviousClientInHotelRoom = 1;
        countOfPreviousClientInHotelRoom = Integer.parseInt(ConfigUtil.getProperties().getProperty("countOfPreviousClientInHotelRoom"));
        System.out.println("по заданным настройкам требуется вывести " + countOfPreviousClientInHotelRoom
                + " предыдущих клиентов\n");
        if (countOfPreviousClientInHotelRoom <= hotelRoomService.getById(idHotelRoom).getPreviousClients().size()) {
            System.out.println("предыдущие клиенты номера:\n" +
                    hotelRoomService.getPreviousClientsWithNeedCount(idHotelRoom, countOfPreviousClientInHotelRoom));
        } else {
            System.out.println("количество предыдущих клиентов в настройках превышает реальное количество предыдущих клиентов");
        }
    }
}
