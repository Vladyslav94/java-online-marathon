package sprint09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.IllegalFormatException;

public class RomanNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        System.out.println(intToRoman(number));
    }

    public static String intToRoman(int number) {
        if(number <= 0 || number > 3999){
            throw new IllegalArgumentException();
        }


        String m[] = {"", "M", "MM", "MMM"};
        String c[] = {"", "C", "CC", "CCC", "CD", "D",
                "DC", "DCC", "DCCC", "CM"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L",
                "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V",
                "VI", "VII", "VIII", "IX"};

        String thousands = m[number/1000];
        String hundereds = c[(number%1000)/100];
        String tens = x[(number%100)/10];
        String ones = i[number%10];

        return thousands + hundereds + tens + ones;
    }
}
