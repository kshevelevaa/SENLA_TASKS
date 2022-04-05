package Model;

import java.time.LocalDate;

public class Celebration extends Maintenance {

    public Celebration(LocalDate checkIn) {
        this.price = 700;
        this.date = checkIn.plusDays(2);
    }

    @Override
    void getName() {

        System.out.println("Decorate the room");
    }

    @Override
    public String toString() {
        return "Celebration{" +
                "price=" + price +
                ", date=" + date +
                '}';
    }
}

