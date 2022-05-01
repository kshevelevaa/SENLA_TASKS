package dao.entity;

import java.util.ArrayList;
import java.util.List;

public class HotelRoom extends dao.entity.AbstractEntity {

    private List<dao.entity.Client> clientsInRoom = new ArrayList<>();
    private List<dao.entity.Client> previousClients = new ArrayList<>();
    private int dayPrice;
    private dao.entity.RoomStatus status = dao.entity.RoomStatus.FREE;
    private long roomNumber;
    private int maxPeopleCount;
    private int starsCount;

    public HotelRoom(long roomNumber, int maxPeopleCount, int dayPrice, int starsCount) {
        this.roomNumber = roomNumber;
        this.maxPeopleCount = maxPeopleCount;
        this.dayPrice = dayPrice;
        this.starsCount = starsCount;
    }

    public List<dao.entity.Client> getClientsInRoom() {
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

    public dao.entity.RoomStatus getStatus() {
        return status;
    }

    public void setStatus(dao.entity.RoomStatus status) {
        this.status = status;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxPeopleCount() {
        return maxPeopleCount;
    }

    public void setMaxPeopleCount(int maxPeopleCount) {
        this.maxPeopleCount = maxPeopleCount;
    }

    public List<Client> getPreviousClientsWithNeedCount(int count) {
        List<Client> previousClientsWithNeedNumber = getPreviousClients();
        previousClientsWithNeedNumber = previousClientsWithNeedNumber.subList(previousClientsWithNeedNumber.size()-count, previousClients.size());
        return previousClientsWithNeedNumber;
    }
    public List<Client> getPreviousClients(){
        return previousClients;
    }

    public void setPreviousClients(List<dao.entity.Client> previousClients) {
        this.previousClients = previousClients;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
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
                " id=" + getId() +
                "}\n";
    }

}
