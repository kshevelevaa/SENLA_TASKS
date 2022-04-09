package View.implAction;

import View.AbstractAction;

public class PrintDetailOfHotelRoom extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("всего " + hotelRoomService.getAll().size() + " комнат, начиная с 0");
        int enter = -1;
        while (enter < 0 || enter > hotelRoomService.getAll().size()) {
            System.out.println("введите номер комнаты");
            enter = scanner.nextInt();
        }
        System.out.println(hotelRoomService.getAll().get(enter));

    }
}
