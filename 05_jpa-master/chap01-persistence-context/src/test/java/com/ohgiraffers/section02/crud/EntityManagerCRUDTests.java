package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class EntityManagerCRUDTests {

    private EntityManagerCRUD crud;

    @BeforeEach
    void initManager() {
        this.crud = new EntityManagerCRUD();
    }

    @AfterEach
    void rollback() {
        EntityTransaction transaction = crud.getManagerInstance().getTransaction();
        transaction.rollback();
    }

    @DisplayName("메뉴 코드로 메뉴 조회 테스트")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "3,3"})
    void testFindMethodByMenuCode(int menuCode, int expected) {
        //when
        Menu foundMenu = crud.findMenuByMenuCode(menuCode);

        //then
        System.out.println(" [ foundMenu" + menuCode + "] " + foundMenu);
        Assertions.assertEquals(expected, foundMenu.getMenuCode());
        Assertions.assertNotNull(foundMenu);
    }

    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of(
                        "신메뉴",
                        35000,
                        4,
                        "Y"
                )
        );

    }

    @DisplayName("새로운 메뉴 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testRegist(String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        //when
        Menu newMenu = new Menu(menuName, menuPrice, categoryCode, orderableStatus);
        Long count = crud.saveAndReturnAllCount(newMenu);

        //then
//        Assertions.assertEquals(23, count);
        Assertions.assertTrue(crud.getManagerInstance().contains(newMenu));


    }

    @DisplayName("메뉴 이름 수정 테스트")
    @ParameterizedTest
    @CsvSource("1, 변경된 메뉴")
    void testModifyMenuName(int menuCode, String menuName) {
        //when
        Menu modifiedMenu = crud.modifyMenuName(menuCode, menuName);

        //then
        Assertions.assertEquals(menuName, modifiedMenu.getMenuName());
    }

    @DisplayName("메뉴 삭제 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testTRemoveMenu(int menuCode) {
        //when
        Long count = crud.removeAndReturnAllCount(menuCode);

        //then
        Assertions.assertEquals(23, count);
    }
}
