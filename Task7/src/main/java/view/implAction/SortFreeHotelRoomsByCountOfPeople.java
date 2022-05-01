package view.implAction;

import view.AbstractAction;

public class SortFreeHotelRoomsByCountOfPeople extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("сортировка свободных номеров по вместимости:\n" + hotelRoomService.sortFreeHotelRoomsByCountOfPeople(hotelRoomService.getAll()));
    }
}
