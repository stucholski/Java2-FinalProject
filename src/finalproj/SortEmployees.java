package finalproj;
import java.util.*;
class Employee {
    /**
     * Represents an employee with a name.
     */
    private String name;
    /**
     * Constructs an employee with the given name.
     *
     * @param name The name of the employee.
     */
    public Employee(String name) {
        this.name = name;
    }
    /**
     * Gets the name of the employee.
     *
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }
}

public class SortEmployees {
    public static void main(String[] args) {
        /**
         *  use of a set and a map for sorting employees.
         */
        //set representing the name of the employees
        Set<Employee> employeeSet = new TreeSet<>(Comparator.comparing(Employee::getName));
        employeeSet.add(new Employee("Jordan"));
        employeeSet.add(new Employee("Jaire"));
        employeeSet.add(new Employee("Rashon"));
        employeeSet.add(new Employee("Jaire")); // Duplicate, won't be added

        // Map representing the age of each employee
        Map<Employee, Integer> employeeAgeMap = new HashMap<>();
        employeeAgeMap.put(new Employee("Jordan"), 30);
        employeeAgeMap.put(new Employee("Jaire"), 35);
        employeeAgeMap.put(new Employee("Rashon"), 28);

        // Displaying the sorted set of employees
        System.out.println("Sorted Employees:");
        for (Employee employee : employeeSet) {
            System.out.println(employee.getName());
        }

        // Displaying the age of each employee from the map
        System.out.println("\nEmployee Ages:");
        for (Map.Entry<Employee, Integer> entry : employeeAgeMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue() + " years old");
        }
    }
}
