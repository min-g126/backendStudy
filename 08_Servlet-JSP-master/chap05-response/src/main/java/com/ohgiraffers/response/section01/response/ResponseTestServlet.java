package com.ohgiraffers.response.section01.response;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * [ Servlet의 역할 ]
        * 1. 요청 받기 : HTTP method GET/POST 요청에 따라 parameter로 전달받은 데이터 꺼낼 수 있다.
        * 2. 비즈니스 로직 처리 = DB 접속 및 CRUD 로직 처리 -> Service를 호출하는 쪽으로 해결(MVC)한다.
        * 3. 응답하기 : 문자열로 동적인 웹(HTML 태그)페이지를 만들고 Stream을 이용해 내보낸다.
        * */

//        PrintWriter out = response.getWriter();

        /* 문자열을 이용해 사용자에게 내보낼 페이지를 작성한다. */
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>안녕 Servlet Response!</h1>\n")
                .append("</body>\n")
                .append("</html>");

        /* 브라우저로 내보낼 데이터의 타입을 응답 헤더에 설정하는데,
        *  content-type 헤더의 값은 null이 기본 값이므로 content-type 설정을 해줘야 한다. */
        System.out.println("default response type : " + response.getContentType());

        /* text/plain으로 설정하면 html 태그를 태그가 아닌 문자열로 인식한다. */
//        response.setContentType("text/html");

        /* 응답 시에도 별도 인코딩을 지정하지 않으면 기본 설정된 인코딩 방식(UTF-8)을 따른다. */
        System.out.println("default response encoding : " + response.getCharacterEncoding());

        /* 인코딩 방식을 변경할 수 있으며, 이때 주의할 점은 반드시 getWriter()로 Stream을 얻어오기 전에 설정해야 한다. */
//        response.setCharacterEncoding("UTF-8");

        /* contentType과 characterEncoding 설정을 한번에 할 수 있다. */
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        /* Stream을 이용해 응답 내용을 내보낸다. */
        out.print(responseBuilder.toString());

        out.flush();
        out.close();
    }

}
