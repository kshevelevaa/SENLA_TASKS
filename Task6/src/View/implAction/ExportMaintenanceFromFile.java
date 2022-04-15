package View.implAction;

import View.AbstractAction;
import View.ReadUtil;

public class ExportMaintenanceFromFile extends AbstractAction {
    @Override
    public void doAction() {
        long idMaintenance = ReadUtil.readIdForExport(maintenanceService);
        maintenanceService.exportMaintenanceFromFile(idMaintenance);

    }

}