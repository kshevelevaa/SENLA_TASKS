package View.implAction;

import View.IAction;

public class ChangeStatusOfHotelRoomOnRepair implements IAction {

    @Override
    public void doAction() {
        hotelRoomService.changeStatusOfHotelRoomOnRepair();
    }
}
