package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class ExportClientFromFile extends AbstractAction {
    @Override
    public void doAction() {
        long idClient = ReadUtil.readIdForExport(clientService);
        clientService.exportClientFromFile(idClient);
    }
}