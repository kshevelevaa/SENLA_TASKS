import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelRoom {

    private List<Client> clientsInRoom = new ArrayList<>();
    private List<Client> previousClients = new ArrayList<>();
    private int dayPrice;
    private int allDayPrice;
    private int totalPrice;
    private Status status = Status.FREE;
    private int number;
    private int maxRoomNumber;//unchangeable
    private int maxPeopleNumber;//unchangeable
    private int maxStarsNumber;//unchangeable
    private List<Service> services = new ArrayList<>();

    HotelRoom(int i) {
        this.number = i;
        this.dayPrice = (int) (Math.random() * (4999)) + 1;
        this.maxRoomNumber = (int) (Math.random() * (4)) + 1;
        this.maxPeopleNumber = (int) (Math.random() * (4)) + 1;
        this.maxStarsNumber = (int) (Math.random() * (4)) + 1;
    }

    public void settle(Client client) {
        //this.clientsInRoom[people] = client;
        clientsInRoom.add(client);
        this.allDayPrice = client.getStayingDays() * dayPrice;
        //this.people++;
        client.setHotelRoom(this.number);
        status = Status.BUSY;
        System.out.println("settle a person");

    }

    public void evict() {
        while (clientsInRoom.size() > 0) {
            previousClients.add(clientsInRoom.get(clientsInRoom.size() - 1));
            clientsInRoom.remove(clientsInRoom.get(clientsInRoom.size() - 1));
        }
        status = Status.FREE;
        System.out.println("evict a person");
    }

    public void changePrice(int price) {
        this.dayPrice = price;
        System.out.println("change price");
    }

    public void changeStatus(Status status) {
        this.status = status;
        System.out.println("change status");
    }

    public void setService(Service serv) {
        services.add(serv);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPriceForServiceOfClient() {
        int allPriceForService = 0;
        for (int i = 0; i < services.size(); i++)
            allPriceForService += services.get(i).getPrice();
        return allPriceForService;
    }

    public List<Service> getService() {
        return services;
    }

    public int getTotalPrice() {
        totalPrice = getPriceForServiceOfClient() + allDayPrice;
        return totalPrice;
    }

    public int getAllDayPrice() {
        return allDayPrice;
    }

    public void getPreviousClients(int count) {
        System.out.println("PREVIOUS CLIENTS:\n");
        for (int i = previousClients.size(); i > (previousClients.size() - count); i--)
            System.out.println(previousClients.get(i - 1));

    }

    public static void getFreeRooms(List<HotelRoom> hotel, LocalDate date) {
        for (int i = 0; i < hotel.size(); i++) {
            if (hotel.get(i).getStatus() == Status.FREE) System.out.println(hotel.get(i));
            if (hotel.get(i).getStatus() == Status.BUSY) {
                long difference = ChronoUnit.DAYS.between(hotel.get(i).getClientsInRoom().get(0).getCheckOut(), date);
                if (difference > 0) System.out.println(hotel.get(i));
            }
        }
    }

    public static int getCountOfFreeRooms(List<HotelRoom> hotel) {
        int countOfFreeRooms = 0;
        for (int i = 0; i < hotel.size(); i++) {
            if (hotel.get(i).getStatus() == Status.FREE)
                countOfFreeRooms++;
        }
        return countOfFreeRooms;
    }

    public int getPrice() {
        return dayPrice;
    }

    public int getCountOfRoom() {
        return maxRoomNumber;
    }

    public int getCountOfPeople() {
        return maxPeopleNumber;
    }

    public int getCountOfStars() {
        return maxStarsNumber;
    }

    public int getPeople() {//count of people in ine room
        return clientsInRoom.size();
    }

    public List<Client> getClientsInRoom() {
        return clientsInRoom;
    }

    public Status getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "people=" + clientsInRoom.size() +
                //", clientsInRoom=" + Arrays.toString(clientsInRoom) +
                //", previousClients=" + previousClients +
                ", dayPrice=" + dayPrice +
                //", allDayPrice=" + allDayPrice +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", number=" + number +
                //", maxRoomNumber=" + maxRoomNumber +
                ", maxPeopleNumber=" + maxPeopleNumber +
                ", maxStarsNumber=" + maxStarsNumber +
                //", services=" + services +
                '}';
    }

}