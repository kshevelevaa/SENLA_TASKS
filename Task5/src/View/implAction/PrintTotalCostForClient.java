package View.implAction;

import View.AbstractAction;

public class PrintTotalCostForClient extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println(clientDao.getAll());
        int idClient = -1;
        while (clientDao.getById(idClient) == null) {
            System.out.println("введите правильный id клиента, для которой нужно вывести общую стоимость номера и услгу сервиса");
            idClient = scanner.nextInt();
        }
        System.out.println("общая стоимость:\n"
                + clientService.getTotalCostForClient(clientDao.getById(idClient)));
    }
}
