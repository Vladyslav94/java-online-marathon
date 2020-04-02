package sprint02;

public class FindSqrt {
    public static void main(String[] args) {

        System.out.println(mySqrt(18));
    }

    public static int mySqrt(int x) {

        if (x == 0) return 0;
        long result = 1;
        for (long i = 1, half = x / 2; i <= half; ) {
            long mid = i + (half - i) / 2;
            if (mid * mid < x) {
                i = mid + 1;
                result = mid;
            } else if (mid * mid > x) {
                half = mid - 1;
            } else {
                return (int) mid;
            }
        }

        return (int) result;
    }
}
