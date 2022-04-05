package View.implAction;

import View.IAction;

public class PrintTotalCostForClient implements IAction {

    @Override
    public void doAction() {
        hotelRoomService.printTotalCostForClient(currentClients.getCurrentClients().get(0));
    }
}
