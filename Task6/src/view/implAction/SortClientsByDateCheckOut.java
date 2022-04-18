package view.implAction;

import view.AbstractAction;

public class SortClientsByDateCheckOut extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("Сортировка клиентов по дате выезда" + clientService.sortClientsByCheckOut(clientService.getAll()));
    }
}
