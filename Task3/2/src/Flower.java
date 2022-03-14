public abstract class Flower {
    public int price;
    abstract void setPrice();
    int getPrice(){
        setPrice();
        return price;
    };

}
