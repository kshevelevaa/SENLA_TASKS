package View.implAction;

import View.AbstractAction;

public class SortHotelRoomsByCountOfStars extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("сортировка номеров по количеству звезд:\n"
                + hotelRoomService.sortHotelRoomsByCountOfStars(hotelRoomService.getAll()));
    }
}
