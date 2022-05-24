package view.implAction;

import view.AbstractAction;

public class SortFreeHotelRoomsByPrice extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("сортировка свободных номеров по цене:\n" +
                hotelRoomService.sortFreeHotelRoomsByPrice(hotelRoomService.getAll()));
    }
}
