package View.implAction;

import View.AbstractAction;
import View.ReadUtil;

public class PrintDetailOfHotelRoom extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("всего " + hotelRoomService.getAll().size() + " комнат, начиная с 0");
        int idHotelRoom= ReadUtil.readInt();
        System.out.println(hotelRoomService.getById(idHotelRoom));

    }
}
