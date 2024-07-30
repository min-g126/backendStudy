package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class EntityLifeCycleTests {

    /*
     *  [ Entity의 생명주기 ]
     *  - 비영속(new/transient) : 영속성 컨텍스트와 전혀 관계가 없는 상태 (식별자가 존재하지 않을 수 있음)
     *  - 영속(managed) : 영속성 컨텍스트에 저장된 상태
     *  - 준영속(detached) : 영속성 컨텍스트에 저장되었다가 분리된 상태
     *  - 삭제(removed) : 삭제된 상태
     * */

    private EntityLifeCycle lifeCycle;

    @BeforeEach
    void setUp() {
        this.lifeCycle = new EntityLifeCycle();
    }

    @DisplayName("비영속 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void testTransient(int menuCode) {
        //when
        Menu foundMenu = lifeCycle.findMenuByMenuCode(menuCode);

        Menu newMenu = new Menu(
                foundMenu.getMenuCode(),
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderableStatus()
        );

        //then
        Assertions.assertNotEquals(foundMenu, newMenu);
        Assertions.assertFalse(lifeCycle.getManagerInstance().contains(newMenu));
    }

    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints= {1, 2, 3})
    void testManagedOtherEntityManager(int menuCode) {
        //when
        Menu menu1 = lifeCycle.findMenuByMenuCode(menuCode);
        Menu menu2 = lifeCycle.findMenuByMenuCode(menuCode);

        //then

        Assertions.assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔티티 매니저가 관리하는 엔티티의 영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testManagedSameEntityManager(int menuCode) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();

        //when
        Menu menu1 = manager.find(Menu.class, menuCode);
        Menu menu2 = manager.find(Menu.class, menuCode);


        //then
        Assertions.assertEquals(menu1, menu2);
    }

    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of("새로운 메뉴", 50000, 4, "Y")
//                , Arguments.of(999, "새로운 메뉴", 50000, 4, "Y")
        );
    }

    @DisplayName("엔티티 영속성 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testManagedNewEntity(/*int menuCode,*/String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();

        Menu menu = new Menu(/*menuCode, */menuName, menuPrice, categoryCode, orderableStatus);

        //when
        transaction.begin();
        manager.persist(menu);
//        Menu foundMenu = manager.find(Menu.class, 999);
        manager.flush();

        //then
        Assertions.assertTrue(manager.contains(menu));
//        Assertions.assertEquals(menu, foundMenu);
        transaction.rollback();

    }

    @DisplayName("엔티티 속성 변경 테스트")
    @ParameterizedTest
    @CsvSource({"1, 빨간짜장면", "2, 까만짬뽕"})
    void testManagedEntityModify(int menuCode, String menuName) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();
        Menu foundMenu = manager.find(Menu.class, menuCode);

        //when
        transaction.begin();
        foundMenu.setMenuName(menuName);
        manager.flush();

        //then
        Menu expectedMenu = manager.find(Menu.class, menuCode);
        Assertions.assertEquals(expectedMenu.getMenuName(), foundMenu.getMenuName());
        transaction.rollback();
    }

    @DisplayName("준영속화 detach 테스트")
    @ParameterizedTest
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachEntity(int menuCode, int menuPrice) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();
        Menu foundMenu = manager.find(Menu.class, menuCode);

        //when
        transaction.begin();
        manager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
        manager.flush();
        /*
        *  [ detach() ]
        *  특정 엔티티만 준영속 상태(영속성 컨텍스트가 관리하던 엔티티 객체를 관리하지 않는 상태)로 만든다.
        * */

        //then
        Assertions.assertNotEquals(menuPrice, manager.find(Menu.class, menuCode).getMenuPrice());
        transaction.rollback();

    }

    @DisplayName("준영속화 detach 후 다시 영속화 테스트")
    @ParameterizedTest(name = "[{index}] 준영속화 된 {0}번 메뉴를 {1}원으로 변경하고 다시 영속화 되는지 확인")
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachAndPersist(int menuCode, int menuPrice) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();
        Menu foundMenu = manager.find(Menu.class, menuCode);

        //when
        transaction.begin();
        manager.detach(foundMenu);
        foundMenu.setMenuPrice(menuPrice);
//        manager.persist(foundMenu);
        /*
         * [ merge() : 병합 ]
         * 파라미터로 넘어온 준영속 엔티티 객체의 식별자 값으로 1차 캐시에서 엔티티 객체를 조회한다.
         * 만약 1차 캐시에 엔티티가 없으면 데이터베이스에서 엔티티를 조회하고 1차 캐시에 저장한다.
         * 조회한 영속 엔티티 객체에 준영속 상태의 엔티티 객체의 값을 병합한 뒤 영속 엔티티 객체를 반환한다.
         * 혹은 조회할 수 없는 데이터의 경우 새로 생성해서 병합한다. (save or update)
         * */
        manager.merge(foundMenu);
        manager.flush();

        //then
        Assertions.assertEquals(menuPrice, manager.find(Menu.class, menuCode).getMenuPrice());
        transaction.rollback();
    }

    @DisplayName("detach 후 merge한 데이터 update 테스트")
    @ParameterizedTest
    @CsvSource({"11, 하얀 민트초코죽", "12, 까만 딸기탕후루"})
    void testMergeUpdate(int menuCode, String menuName) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        Menu foundMenu = manager.find(Menu.class, menuCode);
        manager.detach(foundMenu);

        //when
        foundMenu.setMenuName(menuName);
        Menu refoundMenu = manager.find(Menu.class, menuCode);

        System.out.println("[ foundMenu ] " + foundMenu.hashCode());
        System.out.println("[ refoundMenu ] " + refoundMenu.hashCode());

        manager.merge(foundMenu);

        //then
        Assertions.assertEquals(menuName, manager.find(Menu.class, menuCode).getMenuName());
    }

    @DisplayName("detach 후 merge한 데이터 save 테스트")
    @Test
    void testMergeSave() {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();
        Menu foundMenu = manager.find(Menu.class, 20);
        manager.detach(foundMenu);

        //when
        transaction.begin();
        foundMenu.setMenuName("치약맛 초코 아이스크림");
        foundMenu.setMenuCode(999);
        manager.merge(foundMenu);
        manager.flush();

        //then
        Assertions.assertEquals("치약맛 초코 아이스크림", manager.find(Menu.class, 999).getMenuName());
        transaction.rollback();
    }

    @DisplayName("준영속화 clear 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testClearPersistenceContext(int menuCode) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        Menu foundMenu = manager.find(Menu.class, menuCode);

        //when
        /*
         * [ clear() ]
         * 영속성 컨텍스트를 초기화한다 = 영속성 컨텍스트 내 모든 엔티티를 준영속화 시킨다.
         * */
        manager.clear();

        //then
        Menu expectedMenu = manager.find(Menu.class, menuCode);
        Assertions.assertNotEquals(expectedMenu, foundMenu);
    }

    @DisplayName("준영속화 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testClosePersistenceContext(int menuCode) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        Menu foundMenu = manager.find(Menu.class, menuCode);

        //when
        /*
         * [ close() ]
         * 영속성 컨텍스트를 종료한다 = 영속성 컨텍스트 내 모든 객체를 준영속화 시킨다.
         * */
        manager.close();

        //then
//        Menu expectedMenu = manager.find(Menu.class, menuCode);
//        Assertions.assertNotEquals(expectedMenu, foundMenu);
        Assertions.assertThrows(
                IllegalStateException.class,
                () -> manager.find(Menu.class, menuCode)
        );
    }

    @DisplayName("영속성 엔티티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testRemoveEntity(int menuCode) {
        //given
        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();
        Menu foundMenu = manager.find(Menu.class, menuCode);

        //when
        transaction.begin();
        /*
         * [ remove() ]
         * 엔티티를 영속성 컨텍스트 및 데이터베이스에서 삭제한다.
         * 단, 트랜잭션을 제어하지 않으면 데이터베이스에 영구 반영되지는 않는다.
         * 트랜잭션을 커밋하는 순간 영속성 컨텍스트에서 관리하는 엔티티 객체가 데이터베이스에 반영된다. (= flush)
         * */
        manager.remove(foundMenu);

        /*
         * [ flush() ]
         * 영속성 컨텍스트의 변경 내용을 데이터베이스에 동기화하는 작업을 한다.
         * (등록/수정/삭제한 엔티티를 데이터베이스에 반영)
         * */
        manager.flush();

        //then
//        Assertions.assertFalse(manager.contains(foundMenu));
        Menu refoundMenu = manager.find(Menu.class, menuCode);
        Assertions.assertEquals(null, refoundMenu);
        transaction.rollback();
    }

}
