package View.implAction;

import View.AbstractAction;

public class AddMaintenance extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println(clientDao.getAll());
        System.out.println("введите id клиента, которому хотите добавить услугу");
        int idClient = scanner.nextInt();
        while (clientDao.getById(idClient) == null) {
            System.out.println("клиентов с таким id нет\nвведите правильный id");
            idClient = scanner.nextInt();
        }
        System.out.println(maintenanceDao.getAll());
        System.out.println("выберите id услуги, которую хотите добавить");
        int idMaintenance = scanner.nextInt();
        while (maintenanceDao.getById(idMaintenance) == null) {
            System.out.println("услуг с таким id нет\nвведите правильный id");
            idMaintenance = scanner.nextInt();
        }
        clientService.addMaintenance(clientDao.getById(idClient), maintenanceDao.getById(idMaintenance));
        System.out.println("добивили клиенту " + clientDao.getById(idClient) + " услугу " + maintenanceDao.getById(idMaintenance));
    }
}
