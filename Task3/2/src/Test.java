import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        final int COUNT = 15;//count of flowers
        System.out.println("Price list:\nRose-150\nLily-130\nIris-70\n");
        Bouquet bouquet = new Bouquet();
        for (int i = 0; i < (COUNT / 3); i++) {
            Rose rose = new Rose();
            Lily lily = new Lily();
            Iris iris = new Iris();
            bouquet.addToBouquet(rose);
            bouquet.addToBouquet(lily);
            bouquet.addToBouquet(iris);
        }
        System.out.println("price of your bouquet: " + bouquet.getSum());
        for (int i = 0; i < 3; i++) {//to use abstract method at least somewhere
            bouquet.bouquet[i].smell();
        }

    }
}
