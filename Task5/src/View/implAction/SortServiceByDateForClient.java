package View.implAction;

import View.AbstractAction;

public class SortServiceByDateForClient extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println(clientService.getAll());
        int idClient = -1;
        while (clientService.getById(idClient) == null) {
            System.out.println("введите правильный id клиента, для которой нужно отсортировать список услуг по дате");
            idClient = scanner.nextInt();
        }
        System.out.println("сортировка услуг сервиса по дате:\n"
                + maintenanceService.sortServiceByDateForClient(clientService.getById(idClient)));
    }
}
