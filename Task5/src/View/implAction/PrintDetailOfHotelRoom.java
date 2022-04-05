package View.implAction;

import View.IAction;

public class PrintDetailOfHotelRoom implements IAction {
    @Override
    public void doAction() {
        hotelRoomService.printDetailOfHotelRoom(0);
        hotelRoomService.printDetailOfHotelRoom(1);
        hotelRoomService.printDetailOfHotelRoom(2);
        hotelRoomService.printDetailOfHotelRoom(3);

    }
}
