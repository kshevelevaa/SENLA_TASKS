package Dao.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HotelRoom extends AbstractEntity {

    private List<Client> clientsInRoom = new ArrayList<>();
    private int dayPrice;
    private RoomStatus status = RoomStatus.FREE;
    private long roomNumber;
    private int maxPeopleCount;
    private int starsCount;
    List<Maintenance> maintenance = new ArrayList<>();
    RandomUtil randomUtil = new RandomUtil();

    public HotelRoom(long roomNumber, int maxPeopleCount, int dayPrice, int starsCount) {
        this.id = RandomUtil.generateId();
        this.roomNumber = roomNumber;
        this.maxPeopleCount = maxPeopleCount;
        this.dayPrice = dayPrice;
        this.starsCount = starsCount;
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

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public long getRoomNumber() {
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
                //", maintenance=" + maintenance +
                " id=" + getId() +
                "}\n";
    }
}
