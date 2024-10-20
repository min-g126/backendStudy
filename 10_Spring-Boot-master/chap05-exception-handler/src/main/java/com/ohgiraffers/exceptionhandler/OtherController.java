package com.ohgiraffers.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherController {

    @GetMapping("other-controller-null")
    public String nullPointerExceptionTest() {

        String str = null;
        System.out.println(str.charAt(0));

        return "/";
    }


    @GetMapping("other-controller-user")
    public String userExceptionTest() throws MemberRegistException {

        boolean check = true;

        if (check) {
            throw new MemberRegistException("당신은 회원의 자격이 없습니다!");
        }

        return "/";
    }

    @GetMapping("other-controller-array")
    public String arrayExceptionTest() {

        double[] array = new double[0];
        System.out.println(array[0]);

        return "/";
    }
}
