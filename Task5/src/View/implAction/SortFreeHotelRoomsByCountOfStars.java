package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortFreeHotelRoomsByCountOfStars implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortFreeHotelRoomsByCountOfStars(hotelRoomService.getHotel());
    }
}
