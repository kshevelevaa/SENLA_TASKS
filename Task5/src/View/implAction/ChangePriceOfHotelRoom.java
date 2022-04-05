package View.implAction;

import View.IAction;

public class ChangePriceOfHotelRoom implements IAction {
    @Override
    public void doAction() {
        hotelRoomService.changePriceOfHotelRoom();
    }
}
