package view.implAction;

import view.AbstractAction;
import view.ReadUtil;

public class ExportHotelRoomFRomFile extends AbstractAction {
    @Override
    public void doAction() {
        long idHotelRoom = ReadUtil.readIdForExport(hotelRoomService);
        hotelRoomService.exportFromFile(idHotelRoom);
    }
}
