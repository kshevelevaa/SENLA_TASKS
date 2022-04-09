package View.implAction;

import View.AbstractAction;

public class SortFreeHotelRoomsByPrice extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("сортировка свободных номеров по цене:\n" + hotelRoomService.sortFreeHotelRoomsByPrice(hotelRoomDao.getAll()));
    }
}
