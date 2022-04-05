package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortClientsByAlphabet implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortClientsByAlphabet(currentClients.getCurrentClients());
    }
}
