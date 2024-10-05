package com.ohgiraffers.jsp.menu.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/menu/order")
public class MenuOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 1. 요청을 받는다 */
        String menuName = request.getParameter("menuName");
        int amount = Integer.parseInt(request.getParameter("amount"));

        /* 2. 로직을 처리한다 */
        int orderPrice = 0;

        switch (menuName) {
            case "hamburger":
                menuName = "햄버거";
                orderPrice = 8000 * amount; break;
            case "blacknoodle":
                menuName = "짜장면";
                orderPrice = 7000 * amount; break;
            case "rednoodle":
                menuName = "불닭볶음면";
                orderPrice = 2000 * amount; break;
            case "gukbab":
                menuName = "순대국밥";
                orderPrice = 9000 * amount; break;
        }

        /* 3. 응답한다 */
        request.setAttribute("menuName", menuName);
        request.setAttribute("amount", amount);
        request.setAttribute("orderPrice", orderPrice);

        RequestDispatcher rd = request.getRequestDispatcher("/jsp/5_response.jsp");
        rd.forward(request, response);

    }
}
