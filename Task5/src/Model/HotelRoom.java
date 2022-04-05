package Model;

import java.util.ArrayList;
import java.util.List;

public class HotelRoom {

    private List<Client> clientsInRoom = new ArrayList<>();
    private int dayPrice;
    private Status status = Status.FREE;
    private int roomNumber;
    private int maxPeopleCount;
    private int starsCount;
    List<Maintenance> maintenance = new ArrayList<>();

    public HotelRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.maxPeopleCount = (int) (Math.random() * (4)) + 1;
        this.dayPrice = (int) (Math.random() * (4999)) + 1;
        this.starsCount = (int) (Math.random() * (4)) + 1;
    }

    public List<Client> getClientsInRoom() {
        return clientsInRoom;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public void setClientsInRoom(List<Client> clientsInRoom) {
        this.clientsInRoom = clientsInRoom;
    }

    public int getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(int dayPrice) {
        this.dayPrice = dayPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxPeopleCount() {
        return maxPeopleCount;
    }

    public void setMaxPeopleCount(int maxPeopleCount) {
        this.maxPeopleCount = maxPeopleCount;
    }

    public void setMaintenanceList(List<Maintenance> maintenance) {
        this.maintenance = maintenance;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "clientsInRoom=" + clientsInRoom +
                ", dayPrice=" + dayPrice +
                ", status=" + status +
                ", roomNumber=" + roomNumber +
                ", maxPeopleCount=" + maxPeopleCount +
                ", starsCount=" + starsCount +
                ", maintenance=" + maintenance +
                '}';
    }
}
