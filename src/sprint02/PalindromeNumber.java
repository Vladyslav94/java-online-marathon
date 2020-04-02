package sprint02;

public class PalindromeNumber {

    public static void main(String[] args) {

        System.out.println(isPalindrome(3443));
    }

    public static boolean isPalindrome(int number) {
        int r, sum = 0;
        int temp = number;

        while (number > 0) {
            r = number % 10;
            sum = (sum * 10) + r;
            number = number / 10;
        }

        return temp == sum;
    }
}
