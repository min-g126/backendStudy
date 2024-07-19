package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Employee;

import java.util.List;

public class Application4 {

    public static void main(String[] args) {


        FindAllEmployeeService service = new FindAllEmployeeService();
        List<Employee> employees = service.findAllEmployees("DESC");

        employees.forEach(System.out::println);
    }


}
