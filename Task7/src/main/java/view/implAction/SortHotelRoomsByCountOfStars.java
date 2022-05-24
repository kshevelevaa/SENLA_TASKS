package view.implAction;

import view.AbstractAction;

public class SortHotelRoomsByCountOfStars extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("сортировка номеров по количеству звезд:\n"
                + hotelRoomService.sortHotelRoomsByCountOfStars(hotelRoomService.getAll()));
    }
}
