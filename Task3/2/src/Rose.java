public class Rose extends Flower {

    Rose() {
        this.price = 150;
    }

    @Override
    void smell() {
        System.out.println("smells sweet");
    }
}
