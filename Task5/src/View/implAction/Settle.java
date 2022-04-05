package View.implAction;

import View.IAction;

public class Settle implements IAction {
    public void doAction() {
        hotelRoomService.settle(clientsRepository.getFamily1());
        hotelRoomService.settle(clientsRepository.getFamily2());
        hotelRoomService.settle(clientsRepository.getFamily3());
    }
}
