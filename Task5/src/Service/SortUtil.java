package Service;

import Model.Client;
import Model.HotelRoom;
import Model.Maintenance;
import Model.Status;

import java.util.Comparator;
import java.util.List;

public class SortUtil {
    public static void sortHotelRoomsByPrice(List<HotelRoom> hotel) {
        System.out.println("After sorting by price\n");
        hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getDayPrice)).forEach(System.out::println);
    }

    public static void sortFreeHotelRoomsByPrice(List<HotelRoom> hotel) {
        System.out.println("After sorting by price\n");
        hotel.stream().filter(x -> x.getStatus() == Status.FREE).sorted(Comparator.comparingInt(HotelRoom::getDayPrice)).forEach(System.out::println);
    }

    public static void sortHotelRoomsByCountOfPeople(List<HotelRoom> hotel) {
        System.out.println("After sorting by count of people\n");
        hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getMaxPeopleCount)).forEach(System.out::println);
    }

    public static void sortFreeHotelRoomsByCountOfPeople(List<HotelRoom> hotel) {
        System.out.println("After sorting by count of people\n");
        hotel.stream().filter(x -> x.getStatus() == Status.FREE).sorted(Comparator.comparingInt(HotelRoom::getMaxPeopleCount)).forEach(System.out::println);
    }

    public static void sortHotelRoomsByCountOfStars(List<HotelRoom> hotel) {
        System.out.println("After sorting by count of stars\n");
        hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getStarsCount)).forEach(System.out::println);
    }

    public static void sortFreeHotelRoomsByCountOfStars(List<HotelRoom> hotel) {
        System.out.println("After sorting by count of stars\n");
        hotel.stream().filter(x -> x.getStatus() == Status.FREE).sorted(Comparator.comparingInt(HotelRoom::getStarsCount)).forEach(System.out::println);
    }

    public static void sortClientsByAlphabet(List<Client> clients) {
        System.out.println("After sorting by alphabet\n");
        clients.stream().sorted(Comparator.comparing(Client::getSurname)).forEach(System.out::println);
    }

    public static void sortClientsByCheckOut(List<Client> clients) {
        System.out.println("After sorting by check-out\n");
        clients.stream().sorted(Comparator.comparing(Client::getCheckOut)).forEach(System.out::println);
    }

    public static void sortServiceByPrice(List<Maintenance> service) {
        System.out.println("After sorting by price\n");
        service.stream().sorted(Comparator.comparing(Maintenance::getPrice)).forEach(System.out::println);
    }

    public static void sortServiceByDate(List<Maintenance> service) {
        System.out.println("After sorting by date\n");
        service.stream().sorted(Comparator.comparing(Maintenance::getDate)).forEach(System.out::println);
    }

//    public static void sortTotalCost(List<Client> clients) {
//        System.out.println("After sorting by total cost\n");
//        clients.stream().sorted(Comparator.comparing(HotelRoomServiceImpl::getTotalCostForClient)).forEach(System.out::println);
//    }

    ;

}
