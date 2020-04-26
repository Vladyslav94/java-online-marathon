package sprint08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MyUtils {
    public static void main(String[] args) {
        int[] array = {2, 6, 9, 10};
        Predicate<Integer> integerPredicate = new Predicate<Integer>() {

            public boolean test(Integer integer) {
                return false;
            }
        };
        System.out.println(getCount(array, integerPredicate));


    }

    public static int getCount(int[] arr, Predicate<Integer> predicate) {
        List<Integer> intList = new ArrayList<Integer>(arr.length);

        for (int i : arr) {
            intList.add(i);
        }

        return (int) intList.stream().filter(predicate).count();
    }



}
