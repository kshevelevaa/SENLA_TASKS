package View.implAction;

import Dao.Entity.RoomStatus;
import View.AbstractAction;
import View.ReadUtil;

public class Evict extends AbstractAction {
    @Override
    public void doAction() {
        for (int i = 0; i < hotelRoomService.getAll().size(); i++) {
            if (hotelRoomService.getAll().get(i).getStatus() == RoomStatus.BUSY)
                System.out.println(hotelRoomService.getAll().get(i));
        }
        System.out.println("выберите номер, из которого нужно выселить клиентов");
        int enter = ReadUtil.readInt();
        while (hotelRoomService.getAll().get(enter).getStatus() != RoomStatus.BUSY) {
            System.out.println("тут некого выселять((");
            enter = scanner.nextInt();
        }
        hotelRoomService.evict(hotelRoomService.getAll().get(enter).getClientsInRoom());

    }
}
