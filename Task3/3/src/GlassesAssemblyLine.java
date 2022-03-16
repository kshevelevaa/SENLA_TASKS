public class GlassesAssemblyLine implements IAssemblyLine {
    private final ILineStep firstStep;
    private final ILineStep secondStep;
    private final ILineStep thirdStep;

    //constructor for building parts
    public GlassesAssemblyLine(ILineStep firstStep, ILineStep secondStep, ILineStep thirdStep) {
        this.firstStep = firstStep;
        this.secondStep = secondStep;
        this.thirdStep = thirdStep;

    }

    //method for installing(assembling) parts
    @Override
    public IProduct assembleProduct(IProduct product) {
        product.installFirstPart(firstStep.buildProductPart());
        product.installSecondPart(secondStep.buildProductPart());
        product.installThirdPart(thirdStep.buildProductPart());
        return product;
    }
}
