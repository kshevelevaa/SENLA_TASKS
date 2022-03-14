public class Glasses implements IProduct{

    TempleLineStep templeLineStep=new TempleLineStep();
    FrameLineStep frameLineStep=new FrameLineStep();
    LensesLineStep lensesLineStep=new LensesLineStep();

    public Glasses(){
        Frame frame=new Frame();
        Lenses lenses=new Lenses();
        Temple temple=new Temple();

    }
    @Override
    public String toString() {
        return "Glasses are made";
    }

    @Override
    public void installFirstPart(IProductPart frame) {

        System.out.println("install frame");
    }

    @Override
    public void installSecondPart(IProductPart lenses) {

        System.out.println("install lenses");
    }

    @Override
    public void installThirdPart(IProductPart temple) {
        System.out.println("install temple");
    }

}
