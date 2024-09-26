package com.ohgiraffers.parameter.section01.queryString;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 이름
        String name = request.getParameter("name");
        System.out.println("이름 : " + name);
        
        // 나이
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("나이 : " + age);
        
        // 생일
        java.sql.Date birthday = java.sql.Date.valueOf(request.getParameter("birthday"));
        System.out.println("생일 : " + birthday);

        // 성별
        String gender = request.getParameter("gender");
        System.out.println("성별 : " + gender);
        
        // 국적
        String national = request.getParameter("national");
        System.out.println("국적 : " + national);
        
        // 취미
        String[] hobbies = request.getParameterValues("hobbies");
        System.out.println("취미 : ");
        for(String hobby : hobbies) {
            System.out.println(hobby + " ");
        }

    }


}
