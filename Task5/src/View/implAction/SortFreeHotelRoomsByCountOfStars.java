package View.implAction;


import View.AbstractAction;

public class SortFreeHotelRoomsByCountOfStars extends AbstractAction {
    @Override
    public void doAction() {
        System.out.println("сортировка свободных номеров по количеству звезд:\n" + hotelRoomService.sortFreeHotelRoomsByCountOfStars(hotelRoomDao.getAll()));
    }
}