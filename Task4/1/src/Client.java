import java.time.LocalDate;
import java.util.*;

public class Client {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private int stayingDays;
    private String name;
    private String surname;
    private int hotelRoom;

    public Client(String name, String surname, int days, LocalDate checkIn) {
        this.checkIn = checkIn;
        this.stayingDays = days;
        checkOut = checkIn.plusDays(days);
        this.name = name;
        this.surname = surname;
    }

    public void setHotelRoom(int number) {
        this.hotelRoom = number;
    }

    public static int getCountOfClients(List<Client> clients) {
        return clients.size();
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public int getStayingDays() {
        return stayingDays;
    }

    public int getHotelRoom() {
        return hotelRoom;
    }

    @Override
    public String toString() {
        return "Client{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", stayingDays=" + stayingDays +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hotelRoom=" + hotelRoom +
                '}' + "\n";
    }


}
