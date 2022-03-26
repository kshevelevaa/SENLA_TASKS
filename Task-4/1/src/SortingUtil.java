import java.util.Comparator;
import java.util.List;

public class SortingUtil {
    public static void sortByPrice(List<HotelRoom> hotel) {
        System.out.println("After sorting by price\n");
        hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getPrice)).forEach(System.out::println);
    }

    public static void sortByCountOfPeople(List<HotelRoom> hotel) {
        System.out.println("After sorting by count of people\n");
        hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getCountOfPeople)).forEach(System.out::println);
    }

    public static void sortByCountOfStars(List<HotelRoom> hotel) {
        System.out.println("After sorting by count of stars\n");
        hotel.stream().sorted(Comparator.comparingInt(HotelRoom::getCountOfStars)).forEach(System.out::println);
    }

    public static void sortClientsByAlphabet(List<Client> clients) {
        System.out.println("After sorting by alphabet\n");
        clients.stream().sorted(Comparator.comparing(Client::getSurname)).forEach(System.out::println);
    }

    public static void sortClientsByCheckOut(List<Client> clients) {
        System.out.println("After sorting by check-out\n");
        clients.stream().sorted(Comparator.comparing(Client::getCheckOut)).forEach(System.out::println);
    }

    public static void sortServiceByPrice(List<Service> service) {
        System.out.println("After sorting by price\n");
        service.stream().sorted(Comparator.comparing(Service::getPrice)).forEach(System.out::println);
    }

    public static void sortServiceByDate(List<Service> service) {
        System.out.println("After sorting by date\n");
        service.stream().sorted(Comparator.comparing(Service::getDate)).forEach(System.out::println);
    }

    public static void sortTotalCost(List<HotelRoom> hotel) {
        System.out.println("After sorting by total cost\n");
        hotel.stream().sorted(Comparator.comparing(HotelRoom::getTotalPrice)).forEach(System.out::println);
    }

    ;
}
