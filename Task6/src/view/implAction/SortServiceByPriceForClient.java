package view.implAction;

import view.AbstractAction;

public class SortServiceByPriceForClient extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println(clientService.getAll());
        int idClient = -1;
        while (clientService.getById(idClient) == null) {
            System.out.println("введите правильный id клиента, для которой нужно отсортировать список услуг по цене");
            idClient = scanner.nextInt();
        }
        System.out.println("сортировка услуг сервиса по цене:\n" + maintenanceService.sortServiceByPriceForClient(clientService.getById(idClient)));
    }
}

