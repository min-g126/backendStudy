package com.ohgiraffers.association.section03.bidirection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class BiDirectionTests {

    @Autowired
    private BiDirectionService biDirectionService;

    /*
     * 데이터베이스의 테이블은 외래키 하나로 양방향 조회가 가능하지만 객체는 서로 다른 두 단방향 참조를 합쳐서 양방향이라고 한다.
     * 따라서 두 개의 연관관계 중 연관관계의 주인을 정하고, 주인이 아닌 연관관계를 하나 더 추가하는 방식으로 작성한다.
     * 양방향 연관관계는 항상 설정하는 것이 아니라 반대 방향으로도 접근하여 객체 그래프 탐색을 할 일이 많을 때만 사용한다.
     *
     * 양방향 연관관계 매핑 시 연관관계의 주인(Owner)라는 이름으로 인해 오해가 있을 수 있는데,
     * 비즈니스 로직상 더 중요하다고 해서 연관관계의 주인이 되는 것이 아니다.
     * 비즈니스 로직에서의 중요도를 배제하고 단순히 외래키 관리자의 의미로 주인을 정해야 한다.
     * 연관관계의 주인은 외래키를 가지고 있는 엔티티이다.
     * */

    @DisplayName("양방향 연관관계 매핑 조회 테스트1 (연관관계의 주인인 객체)")
    @Test
    void biDirectionFindTest1() {
        //given
        int menuCode = 10;

        //when
        /* 진짜 연관관계 : 처음 조회 시부터 조인한 결과를 인출해 온다. */
        Menu foundMenu = biDirectionService.findMenu(menuCode);

        //then
        Assertions.assertEquals(menuCode, foundMenu.getMenuCode());
        System.out.println("[ Menu ] " + foundMenu);
    }

    @DisplayName("양방향 연관관계 매핑 조회 테스트2 (연관관계의 주인이 아닌 객체)")
    @Test
    void biDirectionFindTest2() {
        //given
        int categoryCode = 10;

        //when
        /* 가짜 연관관계 : 해당 엔티티를 조회하고 필요 시 연관관계 엔티티를 조회하는 쿼리를 실행한다. */
        Category foundCategory = biDirectionService.findCategory(categoryCode);

        //then
        Assertions.assertEquals(categoryCode,foundCategory.getCategoryCode());
//        System.out.println("[ Category ] " + foundCategory.getMenuList());
    }

    private static Stream<Arguments> getMenuInfo() {
        return Stream.of(
                Arguments.of(111, "스테이크 크림 파스타", 9800, "Y")
        );
    }

    @DisplayName("양방향 연관관계 주인 객체를 이용한 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getMenuInfo")
    void biDirectionInsertTest1(int menuCode, String menuName, int menuPrice, String orderableStatus) {
        //given
        Category category = biDirectionService.findCategory(4);
        Menu menu = new Menu(menuCode, menuName, menuPrice, category, orderableStatus);

        //when
        //then
        Assertions.assertDoesNotThrow(
                () -> biDirectionService.registMenu(menu)
        );
    }

    private static Stream<Arguments> getCategoryInfo() {
        return Stream.of(
                Arguments.of(111, "양방향 카테고리", null)
        );
    }

    @DisplayName("양방향 연관관계 주인이 아닌 객체를 이용한 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getCategoryInfo")
    void biDirectionInsertTest2(int categoryCode, String categoryName, Integer refCategoryCode) {
        //given
        Category category = new Category(
                categoryCode,
                categoryName,
                refCategoryCode
        );

        //when
        biDirectionService.registCategory(category);

        //then
        Category foundCategory = biDirectionService.findCategory(categoryCode);
        Assertions.assertNotNull(foundCategory);
    }
}
