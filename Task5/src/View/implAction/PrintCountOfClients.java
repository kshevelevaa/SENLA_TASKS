package View.implAction;

import View.IAction;

public class PrintCountOfClients implements IAction {

    @Override
    public void doAction() {
        hotelRoomService.printCountOfClients();
    }
}
