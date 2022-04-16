package View.implAction;

import Service.HotelRoomService;
import View.AbstractAction;
import View.ReadUtil;

public class PrintPreviousClientsInHotelRoom extends AbstractAction {

    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readId(hotelRoomService);;
        System.out.println("предыдущие клиенты номера:\n" + hotelRoomService.PrintPreviousClientsInHotelRoom(idHotelRoom));

    }
}
