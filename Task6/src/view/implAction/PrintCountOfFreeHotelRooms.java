package view.implAction;

import view.AbstractAction;

public class PrintCountOfFreeHotelRooms extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("количество свободных комнат: " + hotelRoomService.getCountOfFreeHotelRooms());
    }
}
