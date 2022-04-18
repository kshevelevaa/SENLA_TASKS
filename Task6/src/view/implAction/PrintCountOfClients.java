package view.implAction;

import view.AbstractAction;

public class PrintCountOfClients extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("общее количество клиентов:" + clientService.getCountOfClients());
    }
}
