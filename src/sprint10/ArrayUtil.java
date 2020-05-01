package sprint10;

import java.math.BigInteger;
import java.util.Objects;

public class ArrayUtil {
    public static void main(String[] args) {
        Array<Integer> set = new Array<>(new Integer[]{1,2,3,4,5});
        Array<Double> set2 = new Array<>(new Double[]{1.0, 3.0, 5.0});
        System.out.println(averageValue(set2));

    }

    public static <T> T setAndReturn(T[] arr, T element, int position){
        arr[position] = element;
        return arr[position];
    }

    public static <T extends Number> double averageValue(Array<T> array){
        double sum = 0;
        for (int i = 0; i < array.length(); i++) {
            sum +=  array.get(i).doubleValue();
        }

        sum /= array.length();
        return sum;
    }
}
