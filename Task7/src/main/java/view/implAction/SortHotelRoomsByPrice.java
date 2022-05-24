package view.implAction;

import view.AbstractAction;

public class SortHotelRoomsByPrice extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("сортировка номеров по цене:\n"
                + hotelRoomService.sortHotelRoomsByPrice(hotelRoomService.getAll()));
    }
}
