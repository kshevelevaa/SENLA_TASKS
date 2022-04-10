package Dao.Entity;

import java.time.LocalDateTime;

public class Maintenance extends AbstractEntity {
    String name;
    int price;
    LocalDateTime date;

    @Override
    public String toString() {
        return "Maintenance{" +
                "name='" + name + '\'' +
                "id=" + getId() +
                ", price=" + price +
                ", date=" + date +
                '}';
    }

    public Maintenance(String name, int price, LocalDateTime date) {
        this.id = GenerateId.generateId();
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
