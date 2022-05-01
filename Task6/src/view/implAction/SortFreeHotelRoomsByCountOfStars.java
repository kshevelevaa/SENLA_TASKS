package view.implAction;


import view.AbstractAction;

public class SortFreeHotelRoomsByCountOfStars extends AbstractAction {

    @Override
    public void doAction() {
        System.out.println("сортировка свободных номеров по количеству звезд:\n" +
                hotelRoomService.sortFreeHotelRoomsByCountOfStars(hotelRoomService.getAll()));
    }
}