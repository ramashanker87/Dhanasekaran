package com.rama.app.list;
import com.rama.app.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListEmployee {
    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();
        Employee employee1= new Employee("emp1",20,"abc_limited","120",15000);
        Employee employee2= new Employee("emp2",26,"abc_limited","121",25000);
        Employee employee3= new Employee("emp3",31,"abc_limited","122",35000);
        Employee employee4= new Employee("emp4",36,"abc_limited","123",55000);
        Employee employee5= new Employee("emp5",22,"abc_limited","124",30000);
        Employee employee6= new Employee("emp6",45,"abc_limited","125",40000);
        Employee employee7= new Employee("emp7",33,"abc_limited","126",60000);
        Employee employee8= new Employee("emp8",42,"abc_limited","127",52000);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        employeeList.add(employee8);
        //for (Employee employee:employeeList) {
        //    employee.print();
        //}
        System.out.println("Employees with Salary above 50K:");
        List<Employee> salaryGreaterThan50K=employeeList.stream()
                .filter(employee -> employee.getSalary()>50000)
                .collect(Collectors.toList());
        for (Employee employee : salaryGreaterThan50K) {
            employee.print();
        }
        System.out.println("Employees with Age less than 30:");
        List<Employee> ageLessThan30=employeeList.stream()
                .filter(employee -> employee.getAge()<30)
                .collect(Collectors.toList());
        for (Employee employee : ageLessThan30) {
            employee.print();
        }
    }
}
