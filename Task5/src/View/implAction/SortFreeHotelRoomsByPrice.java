package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortFreeHotelRoomsByPrice implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortFreeHotelRoomsByPrice(hotelRoomService.getHotel());
    }
}
