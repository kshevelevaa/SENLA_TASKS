public class Client {
    private String name;
    private String surname;

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hotelRoom=" + hotelRoom +
                '}';
    }

    private int hotelRoom;
    public Client(String name, String surname){
        this.name=name;
        this.surname=surname;
    }

}
