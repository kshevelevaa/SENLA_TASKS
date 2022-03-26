import java.time.LocalDate;
import java.util.Locale;

public abstract class Service {

    int price;
    LocalDate date;

    public void setPrice(int price) {
        this.price = price;
    }

    ;

    public int getPrice() {
        return price;
    }

    ;

    public LocalDate getDate() {
        return date;
    }

    ;

    abstract void getName();


}
