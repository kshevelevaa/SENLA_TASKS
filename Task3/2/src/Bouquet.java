public class Bouquet {
    Flower[] bouquet=new Flower[55];
    public void addToBouquet(Flower flower){
        int i=0;
        while(bouquet[i]!=null) i++;
        bouquet[i]=flower;
    }
    public int getSum(int count){
        int sum=0;
        for(int i=0;i<count;i++){
            sum+=bouquet[i].getPrice();
        }
        return sum;
    }

}
