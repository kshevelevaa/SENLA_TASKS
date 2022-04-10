package View.implAction;

import Dao.Entity.Client;
import View.AbstractAction;
import View.ReadUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Settle extends AbstractAction {
    public void doAction() {
        int countOfClients = 0;
        while (countOfClients < 1 || countOfClients > 5) {
            System.out.println("Максимальное количество человек в номере - 5\nВведите количество клиентов");
            countOfClients = ReadUtil.readInt();
        }
        int stayingDays = 0;
        while (stayingDays < 1) {
            System.out.println("Введите количество дней пребывания");
            stayingDays = ReadUtil.readInt();
        }
        System.out.println("введите фамилию и имя клиентов");
        List<Client> clients = new ArrayList<>();
        for (int i = 0; i < countOfClients; i++) {
            String name = ReadUtil.readString();
            clients.add(new Client(name, stayingDays, LocalDate.now()));
        }
        hotelRoomService.settle(clients);
        for (int i = 0; i < countOfClients; i++) {
            System.out.println(clients.get(i).getName() + " заселили в номер " + clients.get(i).getHotelRoom().getRoomNumber());
        }
    }
}
