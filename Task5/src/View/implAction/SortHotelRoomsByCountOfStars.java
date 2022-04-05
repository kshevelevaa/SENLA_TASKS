package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortHotelRoomsByCountOfStars implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortHotelRoomsByCountOfStars(hotelRoomService.getHotel());
    }
}
