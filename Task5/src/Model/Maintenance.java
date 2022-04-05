package Model;

import java.time.LocalDate;

public abstract class Maintenance {
    int price;
    LocalDate date;

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    abstract void getName();

}
