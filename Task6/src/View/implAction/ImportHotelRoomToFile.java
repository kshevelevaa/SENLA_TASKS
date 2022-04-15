package View.implAction;

import View.AbstractAction;
import View.ReadUtil;

public class ImportHotelRoomToFile extends AbstractAction {
    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readId(hotelRoomService);
        ReadUtil.checkIdForImport(maintenanceService, idHotelRoom);
        hotelRoomService.importHotelRoomToFile(idHotelRoom);

    }

}