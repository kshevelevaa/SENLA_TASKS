package Model;

import java.time.LocalDate;

public class Food extends Maintenance {

    public Food(LocalDate checkIn) {
        price = 300;
        date = checkIn.plusDays(3);
    }

    @Override
    void getName() {
        System.out.println("Food in the room");
    }

    @Override
    public String toString() {
        return "Food{" +
                "price=" + price +
                ", date=" + date +
                '}';
    }
}
