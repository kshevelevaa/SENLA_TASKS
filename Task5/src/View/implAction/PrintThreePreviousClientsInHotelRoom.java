package View.implAction;

import View.IAction;

public class PrintThreePreviousClientsInHotelRoom implements IAction {

    @Override
    public void doAction() {
        hotelRoomService.printThreePreviousClientsInRoom(0);
        hotelRoomService.printThreePreviousClientsInRoom(1);
        hotelRoomService.printThreePreviousClientsInRoom(2);
        hotelRoomService.printThreePreviousClientsInRoom(3);
    }
}
