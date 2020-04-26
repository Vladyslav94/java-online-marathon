package sprint08.task06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyUtils {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(5);
        integers.add(9);
        integers.add(11);
        integers.add(15);

        Predicate<Integer> predicate = integer -> integer < 9;

        System.out.println(findMaxByCondition(integers, predicate));
        System.out.println(getFilterdValue(findMaxByCondition, predicate));


    }

    static List<Integer> values = new ArrayList<Integer>();
    public static BiFunction<List<Integer>, Predicate<Integer>, Integer> findMaxByCondition = MyUtils::findMaxByCondition;


    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        Collections.sort(numbers);
        List<Integer> integers = numbers.stream().filter(pr).collect(Collectors.toList());
        return integers.get(integers.size() - 1);
    }

    static int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction, Predicate<Integer> predicate) {
        return biFunction.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> pr) {
        BiFunction<List<Integer>, Predicate<Integer>, Integer> findMaxByCondition = MyUtils::findMaxByCondition;
        return getFilterdValue(findMaxByCondition, pr);
    }
}