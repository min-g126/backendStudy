package com.ohgiraffers.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExceptionHandler(NullPointerException exception) {

        System.out.println("global 레벨의 null pointer exception 처리");

        return "error/nullPointer";
    }

    @ExceptionHandler(MemberRegistException.class)
    public String userExceptionHandler(MemberRegistException exception, Model model) {

        System.out.println("global 레벨의 사용자 정의 exception 처리");
        model.addAttribute("exception", exception);

        return "error/memberRegist";
    }

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception exception) {

        return "error/default";
    }
}
