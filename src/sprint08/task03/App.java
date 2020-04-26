package sprint08.task03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class App {
    public static void main(String[] args) {
        BinaryOperator<String> greetingOperator = (s, s2) -> "Hello " + s + " " + s2 + "!!!";

        List<Person> people = new ArrayList<>();
        people.add(new Person("Vasyl", "Petrov"));
        people.add(new Person("Ivan", "Ivanov"));
        people.add(new Person("Miron", "Smirnov"));

        System.out.println(createGreetings(people, greetingOperator));


    }

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> biFunction){
        List<String> strings = new ArrayList<>();

        for (Person person : people) {
            strings.add(biFunction.apply(person.name, person.surname));
        }

        return strings;
    }
}
