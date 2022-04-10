package View.implAction;

import Dao.Entity.RoomStatus;
import Service.HotelRoomService;
import View.AbstractAction;
import View.ReadUtil;


public class ChangeStatusOfHotelRoomOnRepair extends AbstractAction {

    @Override
    public void doAction() {
        ReadUtil<HotelRoomService> hotelRoom = new ReadUtil<>();
        int idHotelRoom = hotelRoom.readId(hotelRoomService);
        hotelRoomService.changeStatusOfHotelRoom(RoomStatus.REPAIR, hotelRoomService.getById(idHotelRoom));
        System.out.println("статус номера изменен на " + hotelRoomService.getById(idHotelRoom).getStatus());
    }
}
