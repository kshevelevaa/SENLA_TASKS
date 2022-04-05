package View.implAction;

import View.IAction;

public class AddHotelRoom implements IAction {
    @Override
    public void doAction() {
        hotelRoomService.addRoom();
    }
}
