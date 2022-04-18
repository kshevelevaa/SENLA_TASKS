package view.implAction;

import dao.entity.RoomStatus;
import view.AbstractAction;
import view.ReadUtil;


public class ChangeStatusOfHotelRoomOnRepair extends AbstractAction {

    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readId(hotelRoomService);
        hotelRoomService.changeStatusOfHotelRoom(RoomStatus.REPAIR, idHotelRoom);
        System.out.println("статус номера изменен на " + hotelRoomService.getById(idHotelRoom).getStatus());
    }
}
