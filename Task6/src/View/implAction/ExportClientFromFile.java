package View.implAction;

import View.AbstractAction;
import View.ReadUtil;

public class ExportClientFromFile extends AbstractAction {
    @Override
    public void doAction() {
        long idClient = ReadUtil.readIdForExport(clientService);
        clientService.exportClientFromFile(idClient);

    }

}