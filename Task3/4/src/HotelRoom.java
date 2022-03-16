enum Status {REPAIR, FREE, BUSY}

public class HotelRoom {

    Client client;
    private int price = 1000;
    Status status = Status.FREE;
    int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public void changePrice(int price) {
        this.price = price;
        System.out.println("change price");
    }

    public void changeStatus(Status status) {
        this.status = status;
        System.out.println("change status");
    }

    public void settle(Client client) {
        this.client = client;
        status = Status.BUSY;
        System.out.println("settle a person");

    }

    public void evict() {
        this.client = null;
        status = Status.FREE;
        System.out.println("evict a person");
    }

    @Override
    public String toString() {
        return "HotelRoom{" +
                "client=" + client +
                ", price=" + price +
                ", status=" + status +
                ", number=" + number +
                '}';
    }
}