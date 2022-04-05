package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortServiceByPrice implements IAction {
    @Override
    public void doAction() {

        SortUtil.sortServiceByPrice(clientsRepository.getFamily3().get(0).getMaintenanceList());
    }
}
