package dao.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Maintenance extends AbstractEntity {
    private String name;
    private int price;
    private String dateForJson;
    @JsonIgnore
    private LocalDateTime date;

    public Maintenance() {
    }

    public Maintenance(String name, int price, LocalDateTime date) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.dateForJson = date.toString();
    }

    public String getDateForJson() {
        return dateForJson;
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

    public void setPrice(int price) {this.price = price;}

    public void setDateForJson(String dateForJson) {
        this.dateForJson = dateForJson;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "name='" + name + '\'' +
                "id=" + getId() +
                //", price=" + price +
                ", date=" + dateForJson +
                '}';
    }
}
