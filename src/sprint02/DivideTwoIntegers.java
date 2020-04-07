package sprint02;

import java.util.Comparator;

public class DivideTwoIntegers {
    public static void main(String[] args) {

        System.out.println(divide(-2147483648, 2));
    }

    public static int divide(int dividend, int divisor) {
        long divid;
        if (dividend == Integer.MIN_VALUE) {
            divid = Integer.MAX_VALUE + 1L;
        } else {
            divid = Math.abs(dividend);
        }

        long divis = Math.abs(divisor);

        int count = 0;


        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }


        while (divid >= divis) {
            divid = divid - divis;
            count++;
        }

        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            return count;


        return -count;

    }
}

