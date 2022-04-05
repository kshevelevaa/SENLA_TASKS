package View.implAction;

import View.IAction;

import java.time.LocalDate;

public class PrintHotelRoomsToBeFreeToDate implements IAction {
    @Override
    public void doAction() {
        LocalDate date = LocalDate.now().plusDays((int) (Math.random() * (5)) + 1);
        hotelRoomService.printHotelRoomToBeFreeToData(date);
    }
}
