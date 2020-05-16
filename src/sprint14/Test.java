package sprint14;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream<IntStream> intStreamStream = Stream.of(IntStream.of(-2, -4, 1, 8, 3, 10), IntStream.of(2, -4, 4, 0, 3, 1),
                IntStream.of(1, -4, 3, 5, 3, 1));
        System.out.println(sumEven(intStreamStream));

    }

    public static Stream<Integer> duplicateElements(Stream<Integer> stream) {
        java.util.HashSet<Integer> items = new java.util.HashSet<>();
        java.util.Set<Integer> integers = stream.filter(integer -> !items.add(integer)).filter(java.util.Objects::nonNull).collect(Collectors.toSet());
        return integers.stream().sorted();
    }

    public static long countNumbers(IntStream intNum, Stream<String> strNum) {
        long a = intNum.filter(value -> (value % 3 == 0 || String.valueOf(value).contains("3")) && value != 0).count();
        long b = strNum.filter(java.util.Objects::nonNull).filter(s -> !s.equals("0") && !s.isEmpty() && (s.contains("3") || Integer.parseInt(s) % 3 == 0)).count();
        return a + b;
    }

    public static int sumEven(Stream<IntStream> stream) {
        java.util.Iterator<IntStream> intStreamIterator = stream.iterator();
        int a = 0;
        while (intStreamIterator.hasNext()) {
            try {
                a += intStreamIterator.next().filter(integer -> integer > 0 && integer % 2 == 0).min().getAsInt();
            } catch (NoSuchElementException e) {
                a += 0;
            }
        }
        return a;
    }

    public static Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null)
            throw new NullPointerException();

        java.util.Set<String> strings = new java.util.HashSet<>();

        for (java.util.Map.Entry<String, Stream<String>> entry : map.entrySet()) {
            if (entry.getValue() == null)
                continue;
            java.util.Set<String> v =
                    entry.getValue().filter(java.util.Objects::nonNull).map(s -> s.replaceAll(" ", "")).
                            map(String::toLowerCase).filter(s -> !s.equals("")).
                            map(s -> s.substring(0, 1).toUpperCase() + s.substring(1)).
                            collect(java.util.stream.Collectors.toSet());
            strings.addAll(v);
        }

        return strings.stream().sorted();
    }
}

