package View.implAction;

import Model.TvChannel;
import View.IAction;

public class AddMaintenance implements IAction {
    @Override
    public void doAction() {
        hotelRoomService.addMaintenance(new TvChannel(currentClients.getCurrentClients().get(0).getCheckIn()),
                currentClients.getCurrentClients().get(0));
    }
}
