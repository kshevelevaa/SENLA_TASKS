package View.implAction;

import Service.SortUtil;
import View.IAction;

public class SortFreeHotelRoomsByCountOfPeople implements IAction {
    @Override
    public void doAction() {
        SortUtil.sortFreeHotelRoomsByCountOfPeople(hotelRoomService.getHotel());
    }
}
