package com.ohgiraffers.section01.problem;

import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemsOfUsingDirectSQLTests {

    private Connection con;

    @BeforeEach
    void setConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menu";
        String user = "sahmyook";
        String password = "sahmyook";

        Class.forName(driver);

        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);

    }

    @AfterEach
    void closeConnection() throws SQLException {
        con.rollback();
        con.close();
    }

    /*
     *  [ JDBC API를 이용해 직접 SQL을 다룰 때 발생할 수 있는 문제점 ]
     *  1. 데이터 변환, SQL 작성, JDBC API 코드 등을 중복 작성 (= 개발시간 증가, 유지보수성 악화)
     *  2. SQL 의존적인 개발
     *  3. 패러다임 불일치 문제 (상속, 연관관계, 객체 그래프 탐색)
     *  4. 동일성 보장 문제
     * */


    @Test
    @DisplayName("직접 SQL을 작성하여 메뉴를 조회할 때 발생하는 문제 확인")
    void testDirectSelectSQL() throws SQLException {
        //given
        String query = "SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS FROM TBL_MENU";

        //when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menuList = new ArrayList<>();
        while (rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuName(rset.getString("MENU_NAME"));
            menu.setMenuPrice(rset.getInt("MENU_PRICE"));
            menu.setCategoryCode(rset.getInt("CATEGORY_CODE"));
            menu.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));

            menuList.add(menu);
        }

        //then
        Assertions.assertNotNull(menuList);

        rset.close();
        stmt.close();
    }

    @Test
    @DisplayName("직접 SQL을 작성하여 신규 메뉴 추가 시 발생하는 문제 확인")
    void testDirectInsertSQL() throws SQLException {
        //given
        Menu menu = new Menu();
        menu.setMenuName("고등어단백질쉐이크");
        menu.setMenuPrice(120000);
        menu.setCategoryCode(1);
        menu.setOrderableStatus("Y");

        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) VALUES(?, ?, ?, ?)";

        //when
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, menu.getMenuName());
        pstmt.setInt(2, menu.getMenuPrice());
        pstmt.setInt(3, menu.getCategoryCode());
        pstmt.setString(4, menu.getOrderableStatus());

        int result = pstmt.executeUpdate();

        //then
        Assertions.assertEquals(1, result);

        pstmt.close();

    }

    /* 2. SQL 의존적인 개발 */
    /* 2-1. 조회 항목 변경에 따른 의존성 */

    @Test
    @DisplayName("조회 항목 변경에 따른 의존성 확인")
    void testChangeSelectColumns() throws SQLException {
        //given
        String query = "SELECT MENU_CODE, MENU_NAME FROM TBL_MENU";

        //when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menuList = new ArrayList<>();
        while (rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuName(rset.getString("MENU_NAME"));
//            menu.setMenuPrice(rset.getInt("MENU_PRICE"));

            menuList.add(menu);
        }

        //then
        Assertions.assertNotNull(menuList);

        rset.close();
        stmt.close();
    }


    /* 2-2. 연관된 객체 문제 */
    @Test
    @DisplayName("연관된 객체 문제 확인")
    void testAssociatedObject() throws SQLException {
        //given
        String query = "SELECT A.MENU_CODE, A.MENU_NAME, A.MENU_PRICE, B.CATEGORY_CODE, B.CATEGORY_NAME, A.ORDERABLE_STATUS" +
                " FROM TBL_MENU A" +
                " JOIN TBL_CATEGORY B ON (A.CATEGORY_CODE = B.CATEGORY_CODE)";

        //when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<MenuAndCategory> menuAndCategories = new ArrayList<>();
        while (rset.next()) {
            MenuAndCategory menuAndCategory = new MenuAndCategory();
            menuAndCategory.setMenuCode(rset.getInt("MENU_CODE"));
            menuAndCategory.setMenuName(rset.getString("MENU_NAME"));
            menuAndCategory.setMenuPrice(rset.getInt("MENU_PRICE"));
            menuAndCategory.setCategory(new Category(rset.getInt("CATEGORY_CODE"), rset.getString("CATEGORY_NAME")));
            menuAndCategory.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));

            menuAndCategories.add(menuAndCategory);
        }

        //then
        Assertions.assertNotNull(menuAndCategories);

        rset.close();
        stmt.close();
    }

    /* 3. 패러다임 불이치 (상속, 연관관계, 객체 그래프 탐색) */

    /* 3-1. 상속 문제 */
    /*
     * 객체 지향 언어의 상속 개념과 유사한 것이 데이터베이스의 서브타입엔티티 이다.
     * 유사한 것 같지만 다른 부분은 데이터베이스의 상속은 상속 개념을 데이터로 추상화해서 슈퍼타입과 서브타입으로 구분하고,
     * 슈퍼타입의 모든 속성을 서브타입이 공유하지 못하여 물리적으로 다른 테이블로 분리가 된 형태이다.
     * (설계에 따라서는 속성으로 추가되기도 한다.)
     * 하지만 객체지향의 상속은 슈퍼타입의 속성을 공유해서 사용하므로 여기서 패러다임 불일치 현상이 발생한다.
     */

    /* 4. 동일성 보장 문제 */
    @Test
    @DisplayName("조회한 두 개의 행을 담은 객체의 동일성 비교")
    void testEquals() throws SQLException {
        //given
         String query = "SELECT MENU_CODE, MENU_NAME FROM TBL_MENU WHERE MENU_CODE = 1";

        //when
        Statement stmt1 = con.createStatement();
        ResultSet rset1 = stmt1.executeQuery(query);

        Menu menu1 = null;
        while (rset1.next()) {
            menu1 = new Menu();
            menu1.setMenuCode(rset1.getInt("MENU_CODE"));
            menu1.setMenuName(rset1.getString("MENU_NAME"));
        }

        Statement stmt2 = con.createStatement();
        ResultSet rset2 = stmt2.executeQuery(query);

        Menu menu2 = null;
        while (rset2.next()) {
            menu2 = new Menu();
            menu2.setMenuCode(rset2.getInt("MENU_CODE"));
            menu2.setMenuName(rset2.getString("MENU_NAME"));
        }

        //then
        Assertions.assertFalse(menu1 == menu2);
        Assertions.assertEquals(menu1.getMenuName(), menu2.getMenuName());

        rset1.close();
        stmt1.close();
        rset2.close();
        stmt2.close();
    }


}
