package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String surname;
    private int id;
    private int roomNumber;
    LocalDate checkIn;
    LocalDate checkOut;
    int daysStaying;
    int totalCost;
    List<Maintenance> maintenanceList = new ArrayList<>();

    public Client(String name, String surname, int daysStaying, LocalDate checkIn) {
        this.name = name;
        this.surname = surname;
        this.checkIn = checkIn;
        this.daysStaying = daysStaying;
        checkOut = checkIn.plusDays(daysStaying);

    }

    public List<Maintenance> getMaintenanceList() {
        return maintenanceList;
    }

    public void addMaintenance(Maintenance maintenance) {
        maintenanceList.add(maintenance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public int getDaysStaying() {
        return daysStaying;
    }

    public void setDaysStaying(int daysStaying) {
        this.daysStaying = daysStaying;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", roomNumber=" + roomNumber +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", daysStaying=" + daysStaying +
                '}';
    }

}
