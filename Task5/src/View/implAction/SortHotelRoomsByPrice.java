package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortHotelRoomsByPrice implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortHotelRoomsByPrice(hotelRoomService.getHotel());
    }
}
