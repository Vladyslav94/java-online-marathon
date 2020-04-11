package sprint04;

public class Employee {
    private String fullName;
    private float salary;
    public static void main(String[] args) {

        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        emp1.fullName = "Vasya";
        emp1.salary = 350f;

        emp2.fullName = "Petya";
        emp2.salary = 341f;

        Employee[] employees = new Employee[2];
        employees[0] = emp1;
        employees[1] = emp2;
        String employeesInfo = "[{fullName: \"";


        for (int i = 0; i < employees.length; i++) {
            if(i != employees.length-1)
                employeesInfo += employees[i].fullName + "\", salary: " + employees[i].salary + "}, {fullName: \"";
            else
                employeesInfo += employees[i].fullName + "\", salary: " + employees[i].salary;

        }

        employeesInfo += "}]";

    }
}
