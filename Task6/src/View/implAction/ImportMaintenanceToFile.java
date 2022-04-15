package View.implAction;

import View.AbstractAction;
import View.ReadUtil;

public class ImportMaintenanceToFile extends AbstractAction {
    @Override
    public void doAction() {
        long idMaintenance = ReadUtil.readId(maintenanceService);
        ReadUtil.checkIdForImport(maintenanceService, idMaintenance);
        maintenanceService.importMaintenanceToFile(idMaintenance);

    }

}