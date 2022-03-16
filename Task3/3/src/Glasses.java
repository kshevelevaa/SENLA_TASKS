public class Glasses implements IProduct {

    TempleLineStep templeLineStep = new TempleLineStep();
    FrameLineStep frameLineStep = new FrameLineStep();
    LensesLineStep lensesLineStep = new LensesLineStep();
    IProductPart[] glasses = new IProductPart[3];


    @Override
    public void installFirstPart(IProductPart frame) {

        System.out.println("install frame");
        glasses[0] = frame;

    }

    @Override
    public void installSecondPart(IProductPart lenses) {

        System.out.println("install lenses");
        glasses[1] = lenses;
    }

    @Override
    public void installThirdPart(IProductPart temple) {
        System.out.println("install temple");
        glasses[2] = temple;
    }

    @Override
    public String toString() {
        return "Glasses are made";
    }

}
