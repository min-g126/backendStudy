package com.ohgiraffers.session.section01.session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName : " + firstName);
        System.out.println("lastName : " + lastName);

        HttpSession session = request.getSession();

        System.out.println("session 유지 시간 default : " + session.getMaxInactiveInterval());  // 1800 (= 30분)

        session.setMaxInactiveInterval(60 * 10);    // 세션 만료 시간 10분으로 설정

        System.out.println("session 유지 시간 변경 후 : " + session.getMaxInactiveInterval());

        System.out.println("session id : " + session.getId());

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        response.sendRedirect("redirect");
    }
}
