package View.implAction;

import Service.ClientService;
import Service.HotelRoomService;
import View.AbstractAction;
import View.ReadUtil;

public class PrintTotalCostForClient extends AbstractAction {

    @Override
    public void doAction() {
        ReadUtil<ClientService> hotelRoom = new ReadUtil<>();
        int idClient = hotelRoom.readId(clientService);
        System.out.println("общая стоимость:\n"
                + clientService.getTotalCostForClient(clientService.getById(idClient)));
    }
}
