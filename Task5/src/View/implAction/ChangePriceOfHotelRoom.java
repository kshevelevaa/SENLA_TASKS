package View.implAction;

import View.AbstractAction;

public class ChangePriceOfHotelRoom extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println(hotelRoomDao.getAll());
        int idHotelRoom = -1;
        while (hotelRoomDao.getById(idHotelRoom) == null) {
            System.out.println("введите правильный id комнаты, стоимость которой хотите изменить");
            idHotelRoom = scanner.nextInt();
        }
        System.out.println("введите новую цену комнаты");
        int newPrice = scanner.nextInt();
        System.out.println("старая цена: " + hotelRoomDao.getById(idHotelRoom).getDayPrice());
        hotelRoomService.changePriceOfHotelRoomById(newPrice, hotelRoomDao.getById(idHotelRoom));
        System.out.println("новая цена: " + hotelRoomDao.getById(idHotelRoom).getDayPrice());
    }
}
