package sprint10;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    PersonComparator personComparator = new PersonComparator();

    @Override
    public int compare(Employee o1, Employee o2) {
        if (personComparator.compare(o1, o2) != 0) {
            return personComparator.compare(o1, o2);
        }
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}
