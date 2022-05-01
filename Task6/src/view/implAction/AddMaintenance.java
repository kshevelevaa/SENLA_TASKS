package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class AddMaintenance extends AbstractAction {
    @Override
    public void doAction() {
        long idClient = ReadUtil.readId(clientService);
        long idMaintenance = ReadUtil.readId(maintenanceService);
        clientService.addMaintenance(idClient, idMaintenance);
        System.out.println("добивили клиенту " + clientService.getById(idClient) + " услугу " + maintenanceService.getById(idMaintenance));
    }
}
