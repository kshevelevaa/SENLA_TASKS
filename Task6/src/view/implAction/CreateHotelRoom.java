package view.implAction;

import dao.entity.HotelRoom;
import dao.entity.RandomUtil;
import view.AbstractAction;

public class CreateHotelRoom extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("было комнат: " + hotelRoomService.getAll().size());
        hotelRoomService.create(new HotelRoom(hotelRoomService.getAll().size(), RandomUtil.getMax5(), RandomUtil.getMax5(), RandomUtil.getMax5000()));
        System.out.println("стало комнат: " + hotelRoomService.getAll().size());
    }
}
