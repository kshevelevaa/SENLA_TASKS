package view.implAction;

import view.AbstractAction;

public class SortHotelRoomsByCountOfPeople extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("сортировка номеров по вместимости:\n"
                + hotelRoomService.sortHotelRoomsByCountOfPeople(hotelRoomService.getAll()));
    }
}
