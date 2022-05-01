package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class PrintTotalCostForClient extends AbstractAction {

    @Override
    public void doAction() {
        long idClient = ReadUtil.readId(clientService);
        System.out.println("общая стоимость:\n"
                + clientService.getTotalCostForClient(idClient));
    }
}
