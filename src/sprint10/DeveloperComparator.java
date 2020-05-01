package sprint10;

import java.util.Comparator;

public class DeveloperComparator implements Comparator<Developer> {
    @Override
    public int compare(Developer o1, Developer o2) {
        if(!o1.getName().equals(o2.getName())){
            return o1.getName().compareTo(o2.getName());
        } else if(o1.getAge() != o2.getAge()){
            return o1.getAge() - o2.getAge();
        } else if(o1.getSalary() != o2.getSalary()){
            return Double.compare(o1.getSalary(), o2.getSalary());
        }
        return Integer.compare(o1.getLevel().ordinal(), o2.getLevel().ordinal());
    }
}
