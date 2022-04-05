package View.implAction;

import View.IAction;

public class Evict implements IAction {
    @Override
    public void doAction() {

        hotelRoomService.evict(currentClients.getCurrentClients().get(0));
        hotelRoomService.evict(currentClients.getCurrentClients().get(1));
        hotelRoomService.evict(currentClients.getCurrentClients().get(2));
    }
}
