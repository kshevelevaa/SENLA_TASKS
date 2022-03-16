public class Bouquet {

    Flower[] bouquet = new Flower[55];
    int size=0;

    public void addToBouquet(Flower flower) {
        bouquet[size]=flower;
        size++;
    }

    public int getSum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += bouquet[i].getPrice();
        }
        return sum;
    }

}
