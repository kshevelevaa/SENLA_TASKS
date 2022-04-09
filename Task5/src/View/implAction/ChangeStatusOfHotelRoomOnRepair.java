package View.implAction;

import Dao.Entity.RoomStatus;
import View.AbstractAction;


public class ChangeStatusOfHotelRoomOnRepair extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println(hotelRoomDao.getAll());
        int idHotelRoom = -1;
        while (hotelRoomDao.getById(idHotelRoom) == null) {
            System.out.println("введите правильный id комнаты, статус которой хотите изменить на ремонтируемый");
            idHotelRoom = scanner.nextInt();
        }
        hotelRoomService.changeStatusOfHotelRoom(RoomStatus.REPAIR, hotelRoomDao.getById(idHotelRoom));
        System.out.println("статус номера изменен на " + hotelRoomDao.getById(idHotelRoom).getStatus());
    }
}
