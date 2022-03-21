import java.time.LocalDate;

public class Celebration extends Service{
    Celebration(LocalDate checkIn){
        this.price=700;
        this.date=checkIn.plusDays(2);
    }

    @Override
    public String toString() {
        return "Celebration{" +
                "price=" + price +
                ", date=" + date +
                '}';
    }

    @Override
    void getName() {
        System.out.println("Decorate the room");
    }
}
