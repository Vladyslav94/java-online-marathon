package sprint02;

public class DivideTwoIntegers {
    public static void main(String[] args) {

        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        long temp = divisor;
       if((long) dividend /temp > Integer.MAX_VALUE){
           return Integer.MAX_VALUE;
       }

        return dividend/divisor;
    }
}
