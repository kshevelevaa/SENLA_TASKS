package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortHotelRoomsByCountOfPeople implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortHotelRoomsByCountOfPeople(hotelRoomService.getHotel());
    }
}
