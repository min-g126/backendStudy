package com.ohgiraffers.lifecycle.section02.xml;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;


public class LifecycleTestServlet extends HttpServlet {

    private int initCount = 1;

    private int serviceCount = 1;

    private int destroyCount = 1;

    public LifecycleTestServlet() {
        /* 기본 생성자: 서블릿 최초 호출 시 호출됨 */
        System.out.println("xml 매핑 기본 생성자 호출됨");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        /* 서블릿 컨테이너에 의해 호출되며, 최초 요청 시에만 실행하고 두 번째 요청부터는 호출하지 않음 */
        System.out.println("xml 매핑 init() 메소드 호출 : " + initCount++);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* 서블릿 컨테이너에 의해 호출되며 최초 요청 시에는 init() 이후에 동작하고,
         *  두 번째 요청부터는 init() 호출 없이 바로 service()가 호출됨 */
        System.out.println("xml 매핑 service() 메소드 호출 : " + serviceCount++);
    }

    @Override
    public void destroy() {
        /* 컨테이너가 종료될 때 호출되는 메소드이며, 주로 자원 반납 용도로 사용 */
        System.out.println("xml 매핑 destroy() 메소드 호출 : " + destroyCount++);
    }
}
