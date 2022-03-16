public class Iris extends Flower {

    Iris() {
        this.price = 70;
    }

    @Override
    void smell() {
        System.out.println("smells spicy");
    }
}
