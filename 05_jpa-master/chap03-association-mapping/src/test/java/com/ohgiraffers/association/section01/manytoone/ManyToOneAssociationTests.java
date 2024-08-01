package com.ohgiraffers.association.section01.manytoone;

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
public class ManyToOneAssociationTests {

    @Autowired
    private ManyToOneService manyToOneService;

    /*
     *  [ Association Mapping ]
     *  Entity 클래스 간의 관계를 매핑하는 것을 의미한다.
     *  => 이를 통해 객체를 이용하여 데이터베이스의 테이블 간 관계를 매핑할 수 있다.
     *
     *  [ 다중성에 의한 분류 ]
     *  : 연관 관계가 있는 객체 관계에서 실제로 연관을 가지는 객체의 수에 따라 분류된다.
     *  - 1:1 (OneToOne) 연관 관계
     *  - 1:N (OneToMany) 연관 관계
     *  - N:1 (ManyToOne) 연관 관계
     *  - N:M (ManyToMany) 연관 관계
     *
     *  [ 방향에 따른 분류 ]
     *  : 테이블의 연관 관계는 외래키를 이용한 양방향 연관 관계의 특징을 가진다.
     *    하지만 참조에 의한 객체의 연관 관계는 단방향이다.
     *    객체 간의 연관 관계를 양방향으로 만들고 싶은 경우 반대 쪽에서도 필드를 추가해 참조를 보관하면 된다.
     *    하지만 엄밀하게 이는 양방향 관계가 아니라 단방향 관계 2개로 볼 수 있다.
     *  - 단방향 연관 관계
     *  - 양방향 연관 관계
     * */

    /*
     *  ManyToOne은 다수의 엔티티가 하나의 엔티티를 참조하는 상황에서 사용된다.
     *  예를 들어 하나의 카테고리가 여러 개의 메뉴를 가질 수 있는 상황에서 메뉴 엔티티가 카테고리 엔티티를 참조하는 것이다.
     *  이때 메뉴 엔티티가 Many, 카테고리 엔티티가 One이 된다.
     *
     *  연관 관계를 가지는 엔티티를 조회하는 방법은 객체 그래프 탐색(객체 연관 관계를 사용한 조회), 객체 지향 쿼리(JPQL) 사용이 있다.
     * */

    @DisplayName("N:1 연관관계 객체 그래프 탐색을 이용한 조회 테스트")
    @Test
    void manyToOneFindTest() {
        //given
        int menuCode = 10;

        //when
        Menu foundMenu = manyToOneService.findMenu(menuCode);

        //then
        Category category = foundMenu.getCategory();
        Assertions.assertNotNull(category);
    }

    @DisplayName("N:1 연관관계 객체지향쿼리(JPQL) 사용 카테고리 이름 조회 테스트")
    @Test
    void manyToOneJPQLFindTest() {
        //given
        int menuCode = 10;

        //when
        String categoryName = manyToOneService.findCategoryNameByJpql(menuCode);

        //then
        Assertions.assertNotNull(categoryName);
        System.out.println(categoryName);
    }

    /*
     *  commit()을 할 경우 컨텍스트 내에 저장된 영속성 객체를 insert 하는 쿼리가 동작된다.
     *  단, 카테고리가 존재하는 값이 아니므로 부모 테이블(TBL_CATEGORY)에 값이 먼저 들어있어야 그 카테고리를 참조하는 자식 테이블(TBL_MENU)에 데이터를 넣을 수 있다.
     *  이때 필요한 것은 @ManyToOne 어노테이션에 영속성 전이 설정을 해주는 것이다.
     *  영속성 전이란 특정 엔터티를 영속화할 때 연관된 엔터티도 함께 영속화 한다는 의미이다.
     *  cascade=CascadeType.PERSIST를 설정하면 MenuAndCategory 엔터티를 영속화 할 때 Category 엔터티도 함께 영속화 한다.
     * */

    private static Stream<Arguments> getMenuInfo() {
        return Stream.of(
                Arguments.of(123, "돈가스 스파게티", 30000, 123, "퓨전분식", "Y")
        );
    }

    @DisplayName("N:1 연관관계 객체 삽입 테스트")
    @ParameterizedTest
    @MethodSource("getMenuInfo")
    void manyToOneInsertTest(int menuCode, String menuName, int menuPrice,
                             int categoryCode, String categoryName, String orderableStatus) {
        //given
        MenuDTO menuInfo = new MenuDTO(
                menuCode,
                menuName,
                menuPrice,
                new CategoryDTO(categoryCode, categoryName, null),
                orderableStatus
        );

        //when
        //then
        Assertions.assertDoesNotThrow(
                () -> manyToOneService.registMenu(menuInfo)
        );
    }
}
