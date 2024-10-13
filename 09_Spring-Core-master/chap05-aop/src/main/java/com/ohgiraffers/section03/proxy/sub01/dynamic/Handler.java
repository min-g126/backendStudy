package com.ohgiraffers.section03.proxy.sub01.dynamic;

import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    private final Student student;

    public Handler(Student student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("===== 공부가 너무 하고 싶은 삼육대 학생... =====");
        System.out.println("(호출 대상 메소드) " + method);
        System.out.println("(전달된 인자)");
        for (Object arg : args) {
            System.out.println(arg);
        }
        method.invoke(student, args);

        System.out.println("===== 오늘도 불태웠다! 이제 꿈에서 공부해야지 :D =====);");

        return proxy;
    }
}
