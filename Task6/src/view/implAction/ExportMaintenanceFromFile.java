package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class ExportMaintenanceFromFile extends AbstractAction {
    @Override
    public void doAction() {
        long idMaintenance = ReadUtil.readIdForExport(maintenanceService);
        maintenanceService.exportMaintenanceFromFile(idMaintenance);
    }
}