import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int COUNT_OF_ROOMS = 10;
        List<HotelRoom> hotel = new ArrayList<>();

        for (int i = 0; i < COUNT_OF_ROOMS; i++) {
            HotelRoom hr = new HotelRoom();
            hotel.add(i, hr);
            hotel.get(i).setNumber(i);
        }

        Client client1 = new Client("Ivan", "Ivanov");
        System.out.println(hotel.get(0));

        hotel.get(0).settle(client1);
        System.out.println(hotel.get(0));

        hotel.get(0).evict();
        System.out.println(hotel.get(0));

        hotel.get(0).changeStatus(Status.REPAIR);
        System.out.println(hotel.get(0));

        hotel.get(0).changePrice(1500);
        System.out.println(hotel.get(0));

        HotelRoom hr10 = new HotelRoom();
        System.out.println("count of rooms is " + hotel.size());
        hotel.add(10, hr10);
        System.out.println("count of rooms is " + hotel.size());


    }
}