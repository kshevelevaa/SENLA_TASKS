public class TempleLineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("build temple");
        return new Temple();
    }
}
