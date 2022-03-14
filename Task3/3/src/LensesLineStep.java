public class LensesLineStep implements ILineStep{
    @Override
    public IProductPart buildProductPart() {
        System.out.println("build lenses");
        return new Lenses();
    }
}
