package generics;

import java.util.TimerTask;

public class InhiretanceGenerics {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Manager manager = new Manager();
        employee = manager;

        P<Employee> employeeP = new P<>();
        P<Manager> managerP = new P<>();

        // employeeP = managerP;
    }
}

class P<E> {
}

class Employee {
}

class Manager extends Employee {
}
