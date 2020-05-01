package sprint10;

import java.util.*;

public class Utility {
    public static void main(String[] args) {
        Person[] person = new Person[3];
        Employee[] employee = new Employee[3];
        Developer[] developers = new Developer[3];
        PersonComparator personComparator = new PersonComparator();
        EmployeeComparator employeeComparator = new EmployeeComparator();
        DeveloperComparator developerComparator = new DeveloperComparator();

    }

    public static <T extends Person> void sortPeople(T[] person, Comparator<? super T> comparator){
        Arrays.sort(person, comparator);
    }
}
