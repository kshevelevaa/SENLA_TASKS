package dao.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = ClientDeserializer.class)
public class Client extends AbstractEntity {

    private String name;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    private HotelRoom hotelRoom;

    //long idHotelRoom;

    private ClientStatus clientStatus;

    @JsonIgnore
    LocalDate checkIn;
    @JsonIgnore
    LocalDate checkOut;

    String checkInForJson;
    String checkOutForJson;
    int daysStaying;
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Maintenance> maintenances = new ArrayList<>();

    public Client() {}

    public Client(String name, int daysStaying, LocalDate checkIn) {
        this.clientStatus = ClientStatus.CURRENT;
        this.name = name;
        this.checkIn = checkIn;
        checkInForJson = checkIn.toString();
        this.daysStaying = daysStaying;
        checkOut = checkIn.plusDays(daysStaying);
        checkOutForJson = checkOut.toString();
    }

    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public void setMaintenances(List<Maintenance> maintenanceList) {
        this.maintenances = maintenanceList;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
    }

    public List<Maintenance> getMaintenances() {
        return maintenances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
        this.checkInForJson = checkIn.toString();
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
        this.checkOutForJson = checkOut.toString();
    }

    public int getDaysStaying() {
        return daysStaying;
    }

    public void setDaysStaying(int daysStaying) {
        this.daysStaying = daysStaying;
    }

//    public long getIdHotelRoom() {
//        return idHotelRoom;
//    }
//
//    public void setIdHotelRoom(long idHotelRoom) {
//        this.idHotelRoom = idHotelRoom;
//    }

    public void setCheckInForJson(String checkInForJson) {
        this.checkInForJson = checkInForJson;
        checkIn = LocalDate.parse(checkInForJson);
    }

    public void setCheckOutForJson(String checkOutForJson) {
        this.checkOutForJson = checkOutForJson;
        checkOut = LocalDate.parse(checkOutForJson);
    }

    public String getCheckInForJson() {
        return checkInForJson;
    }

    public String getCheckOutForJson() {
        return checkOutForJson;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                "id=" + getId() +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", daysStaying=" + daysStaying +
                ", clientStatus=" + clientStatus +
                ", hotelRoom=" + hotelRoom +
                "}\n";
    }

}
