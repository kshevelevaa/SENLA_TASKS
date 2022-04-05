package View.implAction;

import View.IAction;

public class PrintCountOfFreeHotelRooms implements IAction {
    @Override
    public void doAction() {
        hotelRoomService.printCountOfFreeHotelRooms();
    }
}
