package View.implAction;

import Service.HotelRoomService;
import View.AbstractAction;
import View.ReadUtil;

public class ChangePriceOfHotelRoom extends AbstractAction {
    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readId(hotelRoomService);;
        System.out.println("введите новую цену комнаты");
        int newPrice = ReadUtil.readInt();
        System.out.println("старая цена: " + hotelRoomService.getById(idHotelRoom).getDayPrice());
        hotelRoomService.changePriceOfHotelRoomById(newPrice, idHotelRoom);
        System.out.println("новая цена: " + hotelRoomService.getById(idHotelRoom).getDayPrice());
    }
}
