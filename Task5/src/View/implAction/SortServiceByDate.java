package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortServiceByDate implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortServiceByDate(currentClients.getCurrentClients().get(0).getMaintenanceList());
    }
}
