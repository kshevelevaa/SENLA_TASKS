package Dao.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client extends AbstractEntity {

    private String name;
    private HotelRoom hotelRoom;
    private ClientStatus clientStatus;
    LocalDate checkIn;
    LocalDate checkOut;
    int daysStaying;
    int totalCost;
    List<Maintenance> maintenances = new ArrayList<>();

    public Client(String name, int daysStaying, LocalDate checkIn) {
        this.id = RandomUtil.generateId();
        this.clientStatus = ClientStatus.CURRENT;
        this.name = name;
        this.checkIn = checkIn;
        this.daysStaying = daysStaying;
        checkOut = checkIn.plusDays(daysStaying);

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

    public int getTotalCost() {
        int maintenancePrice = 0;
        for (int i = 0; i < maintenances.size(); i++) {
            maintenancePrice += maintenances.get(i).getPrice();
        }
        totalCost = daysStaying * hotelRoom.getDayPrice() + maintenancePrice;
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
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
                "id=" + getId() +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", daysStaying=" + daysStaying +
                "}\n";
    }

}
