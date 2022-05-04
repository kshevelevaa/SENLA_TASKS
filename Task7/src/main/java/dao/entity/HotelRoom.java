package dao.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect
@JsonDeserialize(using = HotelRoomDeserializer.class)
public class HotelRoom extends AbstractEntity {

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Client> clientsInRoom = new ArrayList<>();

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private List<Client> previousClients = new ArrayList<>();

    private int dayPrice;
    private RoomStatus status = RoomStatus.FREE;
    private long roomNumber;
    private int maxPeopleCount;
    private int starsCount;

    public HotelRoom() {}

    public HotelRoom(long roomNumber, int maxPeopleCount, int dayPrice, int starsCount) {
        this.roomNumber = roomNumber;
        this.maxPeopleCount = maxPeopleCount;
        this.dayPrice = dayPrice;
        this.starsCount = starsCount;
    }

    public List<Client> getClientsInRoom() {
        return clientsInRoom;
    }

    public void setClientsInRoom(List<Client> clientsInRoom) {
        this.clientsInRoom = clientsInRoom;
    }

    public int getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(int starsCount) {
        this.starsCount = starsCount;
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
        previousClientsWithNeedNumber = previousClientsWithNeedNumber.subList(previousClientsWithNeedNumber.size() - count, previousClients.size());
        return previousClientsWithNeedNumber;
    }

    public List<Client> getPreviousClients() {
        return previousClients;
    }

    public void setPreviousClients(List<Client> previousClients) {
        this.previousClients = previousClients;
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "clientsInRoom=" + clientsInRoom.stream().map(Client::getId).toList() +
                ", dayPrice=" + dayPrice +
                ", status=" + status +
                ", roomNumber=" + roomNumber +
                ", maxPeopleCount=" + maxPeopleCount +
                ", starsCount=" + starsCount +
                " id=" + getId() +
                "}\n";
    }

}
