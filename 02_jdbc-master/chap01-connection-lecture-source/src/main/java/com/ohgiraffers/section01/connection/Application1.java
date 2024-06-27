package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application1 {

    public static void main(String[] args) {

        /* DB 접속을 위한 Connection 인스턴스 생성을 위한 레퍼런스 변수 선언 */
        Connection con = null;

        try {
            /* 사용할 Driver 등록 */
            Class.forName("com.mysql.cj.jdbc.Driver");

            /* DriverManager의 getConnection() 메소드를 이용해 Connection 생성 */
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "sahmyook", "sahmyook");

            System.out.println("con = " + con);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                /* 자원은 반드시 반납해야 하므로 close() 메소드로 자원 반납 */
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
