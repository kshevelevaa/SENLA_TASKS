public class Numbers {
    public static void main (String[] args)
    {
        //generate 3 digits number
        //print the sum of the digits
        int number=(new java.util.Random()).nextInt(9)*100 +
                (new java.util.Random()).nextInt(9)*10+
                (new java.util.Random()).nextInt(9);
        System.out.println("Your number is "+ number);
        int sum=0;
        while(number>0){
                sum+=number%10;
                number/=10;
        };
        System.out.println("Sum is "+ sum);
    }
}

