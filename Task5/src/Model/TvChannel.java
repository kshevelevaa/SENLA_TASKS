package Model;

import java.time.LocalDate;

public class TvChannel extends Maintenance {
    public TvChannel(LocalDate checkIn) {
        this.price = 500;
        date = checkIn.plusDays(1);
    }

    @Override
    public String toString() {
        return "TvChannel{" +
                "price=" + price +
                ", date=" + date +
                '}';
    }

    @Override
    void getName() {
        System.out.println("Connect VIP channel");
    }
}
