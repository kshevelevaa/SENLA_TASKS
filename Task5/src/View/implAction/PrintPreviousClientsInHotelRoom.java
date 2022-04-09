package View.implAction;

import View.AbstractAction;

public class PrintPreviousClientsInHotelRoom extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println(hotelRoomDao.getAll());
        int idHotelRoom = -1;
        while (hotelRoomDao.getById(idHotelRoom) == null) {
            System.out.println("введите правильный id комнаты, для которой нужен список предыдущих клиентов");
            idHotelRoom = scanner.nextInt();
        }
        System.out.println("предыдущие клиенты номера:\n" + hotelRoomService.PrintPreviousClientsInHotelRoom(idHotelRoom));

    }
}
