package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class ImportClientToFile extends AbstractAction {
    @Override
    public void doAction() {
        long idClient = ReadUtil.readId(clientService);
        ReadUtil.checkIdForImport(clientService, idClient);
        clientService.importClientToFile(idClient);
    }
}
