package view.implAction;

import view.AbstractAction;


public class SortClientsByAlphabet extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("Сортировка клиентов по алфавиту" + clientService.sortClientsByAlphabet(clientService.getAll()));
    }
}
