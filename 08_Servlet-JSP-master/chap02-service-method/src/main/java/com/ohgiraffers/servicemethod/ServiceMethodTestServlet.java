package com.ohgiraffers.servicemethod;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {



    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        String httpMethod = httpRequest.getMethod();
        System.out.println("http method : " + httpRequest.getMethod());

        if("GET".equals(httpMethod)) {
            doGet(httpRequest, httpResponse);
        } else if("POST".equals(httpMethod)) {
            doPost(httpRequest, httpResponse);
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 doGet() 호출됨");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 doPost() 호출됨");
    }
}
