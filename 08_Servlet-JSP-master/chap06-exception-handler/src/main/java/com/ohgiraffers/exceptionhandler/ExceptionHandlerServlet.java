package com.ohgiraffers.exceptionhandler;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Enumeration<String> attrNames = request.getAttributeNames();
        while(attrNames.hasMoreElements()) {
            System.out.println(attrNames.nextElement());
        }

        /*
        * jakarta.servlet.forward.request_uri
        * jakarta.servlet.forward.context_path
        * jakarta.servlet.forward.servlet_path
        * jakarta.servlet.forward.mapping
        * jakarta.servlet.error.message
        * jakarta.servlet.error.servlet_name
        * jakarta.servlet.error.request_uri
        * jakarta.servlet.error.status_code
        */
        String forwardRequestURI = (String) request.getAttribute("jakarta.servlet.forward.request_uri");
        String forwardContextPath = (String) request.getAttribute("jakarta.servlet.forward.context_path");
        String forwardServletPath = (String) request.getAttribute("jakarta.servlet.forward.servlet_path");
        HttpServletMapping mapping = request.getHttpServletMapping();
        String errorMessage = (String) request.getAttribute("jakarta.servlet.error.message");
        String errorServletName = (String) request.getAttribute("jakarta.servlet.error.servlet_name");
        String errorRequestURI = (String) request.getAttribute("jakarta.servlet.error.request_uri");
        Integer errorStatusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");

        System.out.println(forwardRequestURI);
        System.out.println(forwardContextPath);
        System.out.println(forwardServletPath);
        System.out.println(mapping.getMappingMatch());
        System.out.println(mapping.getPattern());
        System.out.println(mapping.getServletName());
        System.out.println(mapping.getMatchValue());
        System.out.println(errorMessage);
        System.out.println(errorServletName);
        System.out.println(errorRequestURI);
        System.out.println(errorStatusCode);


        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>\n")
                .append(errorMessage)
                .append(" (")
                .append(errorStatusCode)
                .append(")")
                .append("</h1>\n")
                .append("</body>\n")
                .append("</html>\n");

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print(errorPage.toString());

        out.flush();
        out.close();
    }
}
