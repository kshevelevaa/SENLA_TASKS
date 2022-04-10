package View.implAction;

import Service.ClientService;
import Service.MaintenanceService;
import View.AbstractAction;
import View.ReadUtil;

public class AddMaintenance extends AbstractAction {
    @Override
    public void doAction() {
        ReadUtil<ClientService> client = new ReadUtil<>();
        int idClient = client.readId(clientService);
        ReadUtil<MaintenanceService> maintenance = new ReadUtil<>();
        int idMaintenance = maintenance.readId(maintenanceService);
        clientService.addMaintenance(clientService.getById(idClient), maintenanceService.getById(idMaintenance));
        System.out.println("добивили клиенту " + clientService.getById(idClient) + " услугу " + maintenanceService.getById(idMaintenance));
    }
}
