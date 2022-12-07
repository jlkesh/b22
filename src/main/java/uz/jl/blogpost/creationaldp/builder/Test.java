package uz.jl.blogpost.creationaldp.builder;

public class Test {
    public static void main(String[] args) {
        // Employee employee = new Employee("1","jlkesh");
        // Employee employee2 = new Employee("1","jlkesh","123");
        // Employee employee3 = new Employee("1","jlkesh","active");

        Employee employee1 = Employee.builder()
                .id("1")
                .build();
        System.out.println("employee1 = " + employee1);

        Employee employee = Employee.builder()
                .username("jlkesh")
                .status("active")
                .build();
        System.out.println("employee = " + employee);
    }
}
