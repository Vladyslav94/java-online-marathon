package sprint06;

import java.math.BigDecimal;
import java.util.*;

public class Employee {
        private String name;
        private int experience;
        private BigDecimal basePayment;

        public Employee(String name, int experience, BigDecimal basePayment){
            this.name = name;
            this.experience = experience;
            this.basePayment = basePayment;
        }

        public String getName() {
            return name;
        }

        public int getExperience() {
            return experience;
        }

        public BigDecimal getPayment() {
            return basePayment;
        }





        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(!(obj instanceof Employee))
                return false;
            Employee employee = (Employee) obj;
            return this.name.equals(employee.name) && this.basePayment.equals(employee.basePayment) && this.experience == employee.experience;
        }



        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + name.hashCode();
            result = 31 * result + experience;
            result = 31 * result + basePayment.hashCode();
            return result;
        }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", basePayment=" + basePayment +
                '}';
    }

    }

    class Manager extends Employee{
        private double coefficient;

        public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
            super(name, experience, basePayment);
            this.coefficient = coefficient;
        }

        @Override
        public BigDecimal getPayment() {
            return BigDecimal.valueOf(coefficient).multiply(super.getPayment());
        }

        public double getCoefficient() {
            return coefficient;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(!(obj instanceof Manager))
                return false;
            Manager manager = (Manager) obj;
            return this.getName().equals(manager.getName()) && this.getExperience() == manager.getExperience() &&
                    this.getPayment().equals(manager.getPayment()) && this.coefficient == manager.coefficient;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + getName().hashCode();
            result = 31 * result + getExperience();
            result = 31 * result + getPayment().hashCode();
            return result;
        }

            @Override
    public String toString() {
        return "Manager{" +
                "name='" + this.getName() + '\'' +
                ", experience=" + this.getExperience() +
                ", basePayment=" + super.getPayment() +
                ", coefficient=" + this.coefficient +
                '}';
    }
    }

    class MyUtil {
        public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Ivan", 10, new BigDecimal("3000.00")));


    MyUtil myUtil = new MyUtil();
    System.out.println(myUtil.largestEmployees(employees));

}

        public List<Employee> largestEmployees(List<Employee> workers) {
            Set<Employee> employees = new LinkedHashSet<>(workers);

            Comparator<Employee> maxExperience = new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o2.getExperience() - o1.getExperience();
                }
            };

           Comparator<Employee> maxSalary = new Comparator<Employee>() {
               @Override
               public int compare(Employee o1, Employee o2) {
                   return o2.getPayment().compareTo(o1.getPayment());
               }
           };

           List<Employee> finishList = new ArrayList<>(employees);
           List<Employee> listToReturn = new ArrayList<>();

           finishList.sort(maxExperience);

           for (Employee e:finishList) {
                if(e != null && e.getExperience() == finishList.get(0).getExperience())
                    listToReturn.add(e);
            }

            finishList.sort(maxSalary);
            for (Employee e:finishList) {
                if(e != null && e.getPayment().compareTo(finishList.get(0).getPayment()) == 0)
                    listToReturn.add(e);
            }

            Set<Employee> toReset = new LinkedHashSet<>(listToReturn);


            return new ArrayList<>(toReset);
        }
    }


