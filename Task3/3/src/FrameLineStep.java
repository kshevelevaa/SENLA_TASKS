public class FrameLineStep implements ILineStep{
    @Override
    public IProductPart buildProductPart() {
        System.out.println("build frame");
        return new Frame();
    }
}
