package View.implAction;

import Dao.Entity.HotelRoom;
import Dao.Entity.RandomUtil;
import View.AbstractAction;

public class CreateHotelRoom extends AbstractAction {
    @Override
    public void doAction() {
        long roomNumber = 1;
        roomNumber += hotelRoomService.getAll().size();
        System.out.println("было комнат: " + hotelRoomService.getAll().size());
        hotelRoomService.addHotelRoom(new HotelRoom(roomNumber, RandomUtil.getMax5(), RandomUtil.getMax5(), RandomUtil.getMax5000()));
        System.out.println("стало комнат: " + hotelRoomService.getAll().size());
    }
}
