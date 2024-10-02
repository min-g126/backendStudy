package com.ohgiraffers.session.section01.session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        System.out.println("redirect 페이지 session id : " + session.getId());

        Enumeration<String> sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()) {
            System.out.println(sessionNames.nextElement());
        }

        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>Your first name is ")
                .append(firstName)
                .append(" and last name is ")
                .append(lastName)
                .append("~!</h3>\n")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print(responseText.toString());

        out.flush();
        out.close();
    }

}
