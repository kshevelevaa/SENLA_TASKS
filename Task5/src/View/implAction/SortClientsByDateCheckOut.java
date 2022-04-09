package View.implAction;

import View.AbstractAction;

public class SortClientsByDateCheckOut extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("Сортировка клиентов по дате выезда");
        clientService.sortClientsByCheckOut(clientDao.getAll());
    }
}
