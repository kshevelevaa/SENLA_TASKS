package View.implAction;

import View.AbstractAction;

public class PrintCountOfFreeHotelRooms extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("количество свободных комнат: " + hotelRoomService.getCountOfFreeHotelRooms());
    }
}
