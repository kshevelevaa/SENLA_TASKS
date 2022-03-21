import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

enum Status {REPAIR, FREE, BUSY}

public class HotelRoom {

    int people = 0;
    private Client[] clientsInRoom = new Client[5];
    private List<Client> previousClients=new ArrayList<>();
    private int dayPrice;
    private int allDayPrice;
    private int totalPrice;
    private Status status = Status.FREE;
    private int number;
    private int countOfRoom;
    private int countOfPeople;
    private int countOfStars;
    private List<Service> service = new ArrayList<>();

    HotelRoom(int i) {
        this.number = i;
        this.dayPrice = (int) (Math.random() * (4999)) + 1;
        this.countOfRoom = (int) (Math.random() * (4)) + 1;
        this.countOfPeople = (int) (Math.random() * (4)) + 1;
        this.countOfStars = (int) (Math.random() * (4)) + 1;
    }

    public void settle(Client client) {
        this.clientsInRoom[people] = client;
        this.allDayPrice=client.getStayingDays()*dayPrice;
        this.people++;
        client.setHotelRoom(this.number);
        status = Status.BUSY;
        System.out.println("settle a person");

    }
    public void evict() {
        while (this.people > 0) {
            previousClients.add(clientsInRoom[people-1]);
            clientsInRoom[people] = null;
            people--;
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
        service.add(serv);
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public int getPriceByService() {
        int allPrice = 0;
        for (int i = 0; i < service.size(); i++)
            allPrice += service.get(i).getPrice();
        return allPrice;
    }
    public List<Service> getService() {
        return service;
    }

    public int getTotalPrice(){
        totalPrice=getPriceByService()+allDayPrice;
        return totalPrice;
    }
    public int getAllDayPrice(){
        return allDayPrice;
    }

    public void getPreviousClients(int count){
        System.out.println("PREVIOUS CLIENTS:\n");
        for(int i=previousClients.size();i>(previousClients.size()-count);i--)
            System.out.println(previousClients.get(i-1));

    }
    public static void getFreeRooms(List<HotelRoom> hotel, LocalDate date) {
        for (int i = 0; i < hotel.size(); i++) {
            if (hotel.get(i).getStatus() == Status.FREE) System.out.println(hotel.get(i));
            if (hotel.get(i).getStatus() == Status.BUSY) {
                long difference = ChronoUnit.DAYS.between(hotel.get(i).getClientsInRoom()[0].getCheckOut(), date);
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
        return countOfRoom;
    }

    public int getCountOfPeople() {
        return countOfPeople;
    }

    public int getCountOfStars() {
        return countOfStars;
    }

    public int getPeople() {//count of people in ine room
        return people;
    }

    public Client[] getClientsInRoom() {
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
                "people=" + people +
                //", clientsInRoom=" + Arrays.toString(clientsInRoom) +
                //", previousClients=" + previousClients +
                ", dayPrice=" + dayPrice +
                //", allDayPrice=" + allDayPrice +
                ", totalPrice=" + totalPrice +
                ", status=" + status +
                ", number=" + number +
                //", countOfRoom=" + countOfRoom +
                ", countOfPeople=" + countOfPeople +
                ", countOfStars=" + countOfStars +
                //", service=" + service +
                '}';
    }

}