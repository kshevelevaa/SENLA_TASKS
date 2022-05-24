package view.implAction;

import dao.entity.RoomStatus;
import view.AbstractAction;
import view.ConfigUtil;
import view.ReadUtil;


public class ChangeStatusOfHotelRoomOnRepair extends AbstractAction {

    @Override
    public void doAction() {
        String isHotelRoomStatusChange = ConfigUtil.getProperties().getProperty("isHotelRoomStatusChange");
        if (isHotelRoomStatusChange.equalsIgnoreCase("yes") == false) {
            System.out.println("измените настройки конфигурации и перезапустите программу, чтобы выполнить действие\n");
            return;
        }
        long idHotelRoom = ReadUtil.readId(hotelRoomService);
        hotelRoomService.changeStatusOfHotelRoom(RoomStatus.REPAIR, idHotelRoom);
        System.out.println("статус номера изменен на " + hotelRoomService.getById(idHotelRoom).getStatus());
    }
}
