package View.implAction;

import View.AbstractAction;

public class SortFreeHotelRoomsByCountOfPeople extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("сортировка свободных номеров по вместимости:\n" + hotelRoomService.sortFreeHotelRoomsByCountOfPeople(hotelRoomDao.getAll()));
    }
}
