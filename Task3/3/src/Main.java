public class Main {
    public static void main(String[] args) {
        Glasses glasses=new Glasses();
        GlassesAssemblyLine glassesAssemblyLine=
                new GlassesAssemblyLine(glasses.frameLineStep,glasses.lensesLineStep,glasses.templeLineStep);
        System.out.println(glassesAssemblyLine.assembleProduct(glasses));
    }
}
