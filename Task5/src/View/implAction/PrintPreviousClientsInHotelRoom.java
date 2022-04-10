package View.implAction;

import Service.HotelRoomService;
import View.AbstractAction;
import View.ReadUtil;

public class PrintPreviousClientsInHotelRoom extends AbstractAction {

    @Override
    public void doAction() {
        ReadUtil<HotelRoomService> hotelRoom = new ReadUtil<>();
        int idHotelRoom = hotelRoom.readId(hotelRoomService);
        System.out.println("предыдущие клиенты номера:\n" + hotelRoomService.PrintPreviousClientsInHotelRoom(idHotelRoom));

    }
}
