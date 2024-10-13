package com.ohgiraffers.section03.proxy.sub02.cglib;

import com.ohgiraffers.section03.proxy.common.SahmyookUniStudent;
import org.springframework.cglib.proxy.Enhancer;

public class Application {

    public static void main(String[] args) {

        SahmyookUniStudent student = new SahmyookUniStudent();
        Handler handler = new Handler(student);

        SahmyookUniStudent proxy = (SahmyookUniStudent) Enhancer.create(SahmyookUniStudent.class, handler);

        proxy.study(20);

    }
}
