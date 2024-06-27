package com.ohgiraffers.section02.template;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.section02.template.JDBCTemplate.close;
import static com.ohgiraffers.section02.template.JDBCTemplate.getConnection;

public class Application {

    public static void main(String[] args) {

        /* Connection 객체를 생성하고 반납하는 기능을 static 메소드로 작성하고,
         * 해당 메소드를 import static 해서 사용 */
        Connection con = getConnection();
        System.out.println("con = " + con);

        close(con);
    }
}
