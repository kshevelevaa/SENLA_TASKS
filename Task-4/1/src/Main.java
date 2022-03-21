import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int COUNT_OF_ROOMS = 10;
        List<HotelRoom> hotel = new ArrayList<>();
        List<Client> clients = new ArrayList<>();

        //creating hotel
        for (int i = 0; i < COUNT_OF_ROOMS; i++) {
            HotelRoom hr = new HotelRoom(i + 1);
            hotel.add(i, hr);
            hotel.get(i).setNumber(i);
        }

        //adding previous clients
        LocalDate checkIn01 = LocalDate.now().minusMonths(5);
        LocalDate checkIn02 = LocalDate.now().minusMonths(4);
        LocalDate checkIn03 = LocalDate.now().minusMonths(3);
        Client previousClient1 = new Client("Rita", "Sidorova", 5, checkIn01);
        Client previousClient2 = new Client("Olga", "Selezneva", 3, checkIn02);
        Client previousClient3 = new Client("Vanya", "Gorohov", 4, checkIn03);
        hotel.get(1).settle(previousClient1);
        hotel.get(1).evict();
        hotel.get(1).settle(previousClient2);
        hotel.get(1).evict();
        hotel.get(1).settle(previousClient3);
        hotel.get(1).evict();
//      8
        hotel.get(1).getPreviousClients(3);

        //adding current clients
        //first family
        LocalDate checkIn1 = LocalDate.now().minusDays((int) (Math.random() * (5)) + 1);
        Client client1 = new Client("Ivan", "Ivanov", 6, checkIn1);
        Client client2 = new Client("Maria", "Ivanova", 6, checkIn1);
        for (int i = 0; i < COUNT_OF_ROOMS; i++) {
            if (hotel.get(i).getStatus() == Status.FREE && hotel.get(i).getCountOfPeople() >= 2) {
                hotel.get(i).settle(client1);
                client1.setHotelRoom(i);
                clients.add(client1);
                hotel.get(i).settle(client2);
                client2.setHotelRoom(i);
                clients.add(client2);
                break;
            }
        }

        //second family
        LocalDate checkIn2 = LocalDate.now().minusDays((int) (Math.random() * (2)) + 1);
        Client client3 = new Client("Vladimir", "Petrov", 3, checkIn2);
        Client client4 = new Client("Nina", "Petrova", 3, checkIn2);
        Client client5 = new Client("Denis", "Petrov", 3, checkIn2);
        for (int i = 0; i < COUNT_OF_ROOMS; i++) {
            if (hotel.get(i).getStatus() == Status.FREE && hotel.get(i).getCountOfPeople() >= 3) {
                hotel.get(i).settle(client3);
                //client3.setHotelRoom(i);
                clients.add(client3);
                hotel.get(i).settle(client4);
               // client4.setHotelRoom(i);
                clients.add(client4);
                hotel.get(i).settle(client5);
                //client5.setHotelRoom(i);
                clients.add(client5);
                break;
            }
        }

        //third family
        LocalDate checkIn3 = LocalDate.now().minusDays((int) (Math.random() * (4)) + 1);
        Client client6 = new Client("Anna", "Abrikosova", 8, checkIn3);
        for (int i = 0; i < COUNT_OF_ROOMS; i++) {
            if (hotel.get(i).getStatus() == Status.FREE && hotel.get(i).getCountOfPeople() >= 1) {
                hotel.get(i).settle(client6);
                client6.setHotelRoom(i);
                clients.add(client6);
                break;
            }
        }
//        previous tasks

//        hotel.get(0).evict();
//        System.out.println(hotel.get(0));
//
//        hotel.get(0).changeStatus(Status.REPAIR);
//        System.out.println(hotel.get(0));
//
//        hotel.get(0).changePrice(1500);
//        System.out.println(hotel.get(0));
//
//        HotelRoom hr10 = new HotelRoom();
//        System.out.println("count of rooms is " + hotel.size());
//        hotel.add(10, hr10);
//        System.out.println("count of rooms is " + hotel.size());
//

//          1
        System.out.println(hotel);
        Sorting.sortByPrice(hotel);
        Sorting.sortByCountOfPeople(hotel);
        Sorting.sortByCountOfStars(hotel);

//           2
        List<HotelRoom> freeHotel=new ArrayList<>();
        for(int i=0;i< COUNT_OF_ROOMS; i++){
            if (hotel.get(i).getStatus()==Status.FREE )
                freeHotel.add(hotel.get(i));
        }
        System.out.println("FREE ROOMS:\n");
        Sorting.sortByPrice(freeHotel);
        Sorting.sortByCountOfPeople(freeHotel);
        Sorting.sortByCountOfStars(freeHotel);
//          3

        System.out.println(clients);
        Sorting.sortClientsByAlphabet(clients);
        Sorting.sortClientsByCheckOut(clients);
//          4
        System.out.println("Number of Free rooms: " + HotelRoom.getCountOfFreeRooms(hotel));

//          5
        System.out.println("Number of clients: " + Client.getCountOfClients(clients));
//          6
         LocalDate date1=LocalDate.now().plusDays((int)(Math.random()*(5))+1);
        System.out.println(date1);
        HotelRoom.getFreeRooms(hotel,date1);
//          7
        System.out.println("Total cost of " + client1.getSurname() + client1.getName()+ " is " + hotel.get(client1.getHotelRoom()).getAllDayPrice());
//          9
        Service serv1 = new Food(client1.getCheckIn());
        Service serv2 = new Celebration(client1.getCheckIn());
        Service serv3 = new TvChannel(client1.getCheckIn());
        hotel.get(client1.getHotelRoom()).setService(serv1);
        hotel.get(client1.getHotelRoom()).setService(serv2);
        hotel.get(client1.getHotelRoom()).setService(serv3);
        Sorting.sortServiceByPrice(hotel.get(client1.getHotelRoom()).getService());
        Sorting.sortServiceByDate(hotel.get(client1.getHotelRoom()).getService());
//        10
        Sorting.sortTotalCost(hotel);
//        11
        System.out.println("\n"+hotel.get(9));
//
    }
}