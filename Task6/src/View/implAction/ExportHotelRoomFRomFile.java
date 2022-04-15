package View.implAction;

import View.AbstractAction;
import View.ReadUtil;

public class ExportHotelRoomFRomFile extends AbstractAction {
    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readIdForExport(hotelRoomService);
        hotelRoomService.exportHotelRoomFromFile(idHotelRoom);

    }

}
