package com.ohgiraffers.section01.statement;

import com.ohgiraffers.domain.entity.Employee;

import java.util.Scanner;

public class Application3 {

    public static void main(String[] args) {

        /* 조회할 직원의 직원번호 입력 받기 */
        Scanner sc = new Scanner(System.in);
        System.out.print("조회하실 사번을 입력해주세요 : ");
        String empId = sc.nextLine();

        FindOneEmployeeService service = new FindOneEmployeeService();
        Employee foundEmployee = service.findEmployeeByEmpId(empId);

        System.out.println("foundEmployee = " + foundEmployee);
    }
}

