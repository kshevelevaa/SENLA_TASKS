package View.implAction;

import View.AbstractAction;
import View.ReadUtil;

public class ImportClientToFile extends AbstractAction {
    @Override
    public void doAction() {
        long idClient = ReadUtil.readId(clientService);
        ReadUtil.checkIdForImport(maintenanceService, idClient);
        clientService.importClientToFile(idClient);

    }

}
