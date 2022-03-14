import java.util.Scanner;


public class Test {
    public static void main(String[] args){
    System.out.println("Pricelist:\nRose-150\nLily-130\nIris-70\nHow mush flowers do you want in your bouquet?");
    Scanner sc=new Scanner(System.in);
    int count=sc.nextInt();
    Bouquet bouquet=new Bouquet();
    for (int i=0;i<(count/3);i++){
        Rose rose=new Rose();
        Lily lily=new Lily();
        Iris iris=new Iris();
        bouquet.addToBouquet(rose);
        bouquet.addToBouquet(lily);
        bouquet.addToBouquet(iris);
    }
    if(count%3!=0) count=count-count%3;
        System.out.println("count of flowers in your bouquet: "+ count);
        System.out.println("price of your bouquet: "+ bouquet.getSum(count));

    }
}
