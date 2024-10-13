package com.ohgiraffers.section03.proxy.sub01.dynamic;

import com.ohgiraffers.section03.proxy.common.SahmyookUniStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {

    public static void main(String[] args) {

        Student student = new SahmyookUniStudent();
        Handler handler = new Handler(student);

        Student proxy = (Student) Proxy.newProxyInstance(Student.class.getClassLoader(), new Class[]{Student.class}, handler);

        proxy.study(16);
    }
}
