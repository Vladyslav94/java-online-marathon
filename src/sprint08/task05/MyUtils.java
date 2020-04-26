package sprint08.task05;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyUtils {
    public static void main(String[] args) {


    }

    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> set){
        return set.stream().reduce(x -> true, Predicate::and);
    }
}
