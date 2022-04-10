package View.implAction;

import Service.HotelRoomService;
import View.AbstractAction;
import View.ReadUtil;

public class ChangePriceOfHotelRoom extends AbstractAction {
    @Override
    public void doAction() {
        ReadUtil<HotelRoomService> hotelRoom = new ReadUtil<>();
        int idHotelRoom = hotelRoom.readId(hotelRoomService);
        System.out.println("введите новую цену комнаты");
        int newPrice = scanner.nextInt();
        System.out.println("старая цена: " + hotelRoomService.getById(idHotelRoom).getDayPrice());
        hotelRoomService.changePriceOfHotelRoomById(newPrice, hotelRoomService.getById(idHotelRoom));
        System.out.println("новая цена: " + hotelRoomService.getById(idHotelRoom).getDayPrice());
    }
}
