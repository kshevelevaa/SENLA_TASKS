package View.implAction;

import View.AbstractAction;

public class SortHotelRoomsByCountOfPeople extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("сортировка номеров по вместимости:\n" + hotelRoomService.sortHotelRoomsByCountOfPeople(hotelRoomDao.getAll()));
    }
}
