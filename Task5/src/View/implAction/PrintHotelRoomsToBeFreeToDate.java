package View.implAction;

import Dao.Entity.RandomUtil;
import View.AbstractAction;
import View.ReadUtil;

import java.time.LocalDateTime;

public class PrintHotelRoomsToBeFreeToDate extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("введите количество дней, через которое должна освободиться комната:");
        int days = ReadUtil.readInt();
        LocalDateTime date = LocalDateTime.now().plusDays(days);
        System.out.println("свободные комнаты к " + date + "\n");
        hotelRoomService.getHotelRoomFreeOnData(date);

    }
}
