package View.implAction;

import Service.ClientService;
import Service.HotelRoomService;
import View.AbstractAction;
import View.ReadUtil;

public class PrintTotalCostForClient extends AbstractAction {

    @Override
    public void doAction() {
        long idClient = ReadUtil.readId(clientService);
        System.out.println("общая стоимость:\n"
                + clientService.getTotalCostForClient(idClient));
    }
}
