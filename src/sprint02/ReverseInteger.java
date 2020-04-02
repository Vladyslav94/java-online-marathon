package sprint02;

public class ReverseInteger {
    public static void main(String[] args) {

        System.out.println(reverse(153423646));
    }

    public static int reverse(int number) {

        int reverseNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            if (reverseNumber > Integer.MAX_VALUE / 10 || (reverseNumber == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (reverseNumber < Integer.MIN_VALUE / 10 || (reverseNumber == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            reverseNumber = reverseNumber * 10 + digit;
            number /= 10;
        }

        return reverseNumber;
    }

}
