package com.ohgiraffers.forward;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        System.out.println("userId : " + userId);
        System.out.println("password : " + password);

        /*
        * 어떤 서블릿으로 위임할 것인지 대상 서블릿을 지정하는
        * 인스턴스(RequestDispatcher)를 생성하고
        * forward() method를 통해 요청과 응답에 대한 정보를 전달하여
        * 나머지 작업을 수행하도록 '위임'한다.
        * 이때 다른 서블릿으로 요청하기 위한 데이터는
        * request에 setAttribute()로 전달하여
        * 받는 쪽에서 getAttribute()로 꺼내 쓰도록 한다.
        * */

        request.setAttribute("userName", "토끼");

        RequestDispatcher rd = request.getRequestDispatcher("print");
        rd.forward(request, response);
    }
}
