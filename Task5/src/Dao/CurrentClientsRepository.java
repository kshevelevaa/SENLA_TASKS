package Dao;

import Model.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CurrentClientsRepository {

    List<Client> family1 = new ArrayList<>();
    LocalDate checkIn1 = LocalDate.now().minusDays((int) (Math.random() * (5)) + 1);
    Client client1 = new Client("Ivan", "Ivanov", 6, checkIn1);
    Client client2 = new Client("Maria", "Ivanova", 6, checkIn1);

    List<Client> family2 = new ArrayList<>();
    LocalDate checkIn2 = LocalDate.now().minusDays((int) (Math.random() * (2)) + 1);
    Client client3 = new Client("Vladimir", "Petrov", 3, checkIn2);
    Client client4 = new Client("Nina", "Petrova", 3, checkIn2);
    Client client5 = new Client("Denis", "Petrov", 3, checkIn2);

    List<Client> family3 = new ArrayList<>();
    LocalDate checkIn3 = LocalDate.now().minusDays((int) (Math.random() * (4)) + 1);
    Client client6 = new Client("Anna", "Abrikosova", 8, checkIn3);

    public List<Client> getFamily1() {
        family1.add(client1);
        family1.add(client2);
        return family1;
    }

    public List<Client> getFamily2() {
        family2.add(client3);
        family2.add(client4);
        family2.add(client5);
        return family2;
    }

    public List<Client> getFamily3() {
        family3.add(client6);
        return family3;
    }
}
