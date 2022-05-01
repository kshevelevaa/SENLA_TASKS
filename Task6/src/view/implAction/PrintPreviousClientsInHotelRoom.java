package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class PrintPreviousClientsInHotelRoom extends AbstractAction {

    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readId(hotelRoomService);
        System.out.println("предыдущие клиенты номера:\n" + hotelRoomService.PrintPreviousClientsInHotelRoom(idHotelRoom));
    }
}
