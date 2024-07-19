package com.ohgiraffers.section01.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    public static void main(String[] args) {

        // CRUD 연산
        // C(Create)  : insert
        // R(Read) : select
        // U(Update) : update
        // D(Delete) : delete

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0;

        String query = "INSERT INTO TBL_MENU (MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) " +
                "VALUES (?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "봉골레청국장");
            pstmt.setInt(2, 50000);
            pstmt.setInt(3, 4);
            pstmt.setString(4, "Y");

            result = pstmt.executeUpdate();

            if (result > 0) {
                con.commit();
            } else {
               con.rollback();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(con);
        }

        System.out.println("result = " + result);

    }
}
