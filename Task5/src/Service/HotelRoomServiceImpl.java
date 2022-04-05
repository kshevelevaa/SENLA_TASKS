package Service;

import Dao.*;
import Model.*;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;


public class HotelRoomServiceImpl extends Dao.HotelRoomDaoImpl {
    ClientsDao currentClients = new ClientsDao();
    PreviousClientsDao previousClients = new PreviousClientsDao();


    public void settle(List<Client> clients) {
        int i = 0;
        while (i < hotel.size()) {
            if (clients.size() <= hotel.get(i).getMaxPeopleCount() && hotel.get(i).getStatus() == Status.FREE) {
                hotel.get(i).setClientsInRoom(clients);
                break;
            } else i++;
        }
        for (int j = 0; j < clients.size(); j++) {
            currentClients.addClient(clients.get(j));
            System.out.println("* поселили : " + clients.get(j).getName() + clients.get(j).getSurname() + " в номер " + i);
        }
        hotel.get(i).setStatus(Status.BUSY);
    }
    //to evict family
//    public void evict(List<Client> clients) {
//        int roomNumber=clients.get(0).getRoomNumber();
//        //for (int j = 0; j < clients.size(); j++) {
//        while(clients.size()!=0){
//            currentClients.deleteClient(clients.get(clients.size()));
//            previousClients.addClient(clients.get(clients.size()));
//            hotel.get(clients.get(0).getRoomNumber()).getClientsInRoom().remove(clients.get(clients.size()));
//            System.out.println("выселен: " + clients.get(clients.size()).getName() + clients.get(clients.size()).getSurname());
//        }
//        hotel.get(roomNumber).setStatus(Status.FREE);
//
//    }

    public void evict(Client client) {
        int roomNumber = client.getRoomNumber();
        currentClients.deleteClient((client));
        previousClients.addClient(client);
        hotel.get(roomNumber).getClientsInRoom().remove(client);
        System.out.println("выселен: " + client.getName() + client.getSurname());
        hotel.get(roomNumber).setStatus(Status.FREE);

    }

    public void printCountOfClients() {
        System.out.println("количество клиентов: " + currentClients.getCurrentClients().size());
    }

    public void changePriceOfHotelRoom() {
        hotel.get(0).setDayPrice(10000);
        System.out.println("* цена первого номера изменена на 10000 *");
    }

    public void changeStatusOfHotelRoomOnRepair() {
        hotel.get(0).setStatus(Status.REPAIR);
        System.out.println("* статус первого номера изменен на ремонтируемый *");
    }

    public void printCountOfFreeHotelRooms() {

        int countOfFreeHotelRooms = 0;
        for (int i = 0; i < getHotelSize(); i++) {
            if (hotel.get(i).getStatus() == Status.FREE) countOfFreeHotelRooms++;
        }
        System.out.println("* количество свободных номеров: " + countOfFreeHotelRooms + "*");
    }

    public void printThreePreviousClientsInRoom(int roomNumber) {
        int count = 3;
        System.out.println("Прошлые клиенты комнаты №" + roomNumber);
        for (int i = previousClients.getPreviousClients().size() - 1; i >= 0; i--) {
            if (previousClients.getPreviousClients().get(i).getRoomNumber() == roomNumber && count > 0) {
                System.out.println(previousClients.getPreviousClients().get(i));
                count--;
            }
        }
    }

    public ClientsDao getCurrentClients() {
        return currentClients;
    }

    public int getMaintenancePriceForClient(Client client) {
        int maintenancePrice = 0;
        for (int i = 0; i < client.getMaintenanceList().size(); i++) {
            maintenancePrice += client.getMaintenanceList().get(i).getPrice();
        }
        return maintenancePrice;
    }

    public int getTotalCostForClient(Client client) {
        int totalCost = getMaintenancePriceForClient(client) + hotel.get(client.getRoomNumber()).getDayPrice() * client.getDaysStaying();
        return totalCost;
    }

    public void printTotalCostForClient(Client client) {
        System.out.println("общая стоимость номера и услуг сервиса для " + client.getName() + client.getSurname() + getTotalCostForClient(client));
    }

    public void addMaintenance(Maintenance maintenance, Client client) {
        client.addMaintenance(maintenance);
        System.out.println("добавили клиенту" + client.getName() + client.getSurname() + "услугу: " + maintenance);
    }

    public void printDetailOfHotelRoom(int roomNumber) {
        System.out.println(hotel.get(roomNumber));
    }

    public void printHotelRoomToBeFreeToData(LocalDate date) {
        System.out.println("комнаты свободные к заданной дате: " + date);
        for (int i = 0; i < hotel.size(); i++) {
            if (hotel.get(i).getStatus() == Status.FREE) System.out.println(hotel.get(i));
            if (hotel.get(i).getStatus() == Status.BUSY) {
                long difference = ChronoUnit.DAYS.between(hotel.get(i).getClientsInRoom().get(0).getCheckOut(), date);
                if (difference > 0) System.out.println(hotel.get(i));
            }
        }
    }

}
