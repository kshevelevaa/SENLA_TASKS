package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class ImportMaintenanceToFile extends AbstractAction {
    @Override
    public void doAction() {
        long idMaintenance = ReadUtil.readId(maintenanceService);
        ReadUtil.checkIdForImport(maintenanceService, idMaintenance);
        maintenanceService.importToFile(idMaintenance);
    }
}