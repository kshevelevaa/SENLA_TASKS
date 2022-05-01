package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class ImportHotelRoomToFile extends AbstractAction {
    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readId(hotelRoomService);
        ReadUtil.checkIdForImport(hotelRoomService, idHotelRoom);
        hotelRoomService.importToFile(idHotelRoom);
    }
}