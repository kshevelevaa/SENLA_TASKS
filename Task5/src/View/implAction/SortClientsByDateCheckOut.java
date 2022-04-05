package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortClientsByDateCheckOut implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortClientsByCheckOut(currentClients.getCurrentClients());
    }
}
