package com.ohgiraffers.section01.entitymanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;

public class EntityManagerGeneratorTests {

    @BeforeAll
    static void beforeAllTest() { System.out.println("=========== @BeforeAll =========="); }

    @BeforeEach
    void beforeEachTest() { System.out.println("=========== @BeforeEach =========="); }

    @AfterEach
    void afterEachTest() { System.out.println("=========== @AfterEach =========="); }

    @AfterAll
    static void afterAllTest() { System.out.println("=========== @AfterAll =========="); }



    /*
     *  [ 엔티티 매니저 팩토리(EntityManagerFactory) ]
     *  엔티티 매니저를 생성할 수 있는 기능을 제공하는 팩토리 클래스이다.
     *  thread-safe하기 때문에 여러 스레드가 동시에 접근해도 안전하므로 서로 다른 스레드 간 공유해서 재사용한다.
     *  thread-safe한 기능을 요청 스코프마다 생성하기에는 비용(시간, 메모리) 부담이 크므로
     *  application 스코프와 동일하게 싱글톤으로 생성해서 관리하는 것이 효율적이다.
     *  따라서 데이터베이스를 사용하는 애플리케이션 당 한 개의 EntityManagerFactory를 생성한다.
     * */

    @Test
    @DisplayName("엔티티 매니저 팩토리 생성 확인")
    void testGenerateEntityManagerFactory() {
        //given

        //when
        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();

        //then
        System.out.println("[ EntityManagerFactory Test ] " + factory.hashCode());
        Assertions.assertNotNull(factory);
    }

    @Test
    @DisplayName("엔티티 매니저 팩토리 싱글톤 인스턴스 확인")
    void testIsEntityManagerFactorySingletonInstance() {
        //given
        EntityManagerFactory factory1 = EntityManagerFactoryGenerator.getInstance();

        //when
        EntityManagerFactory factory2 = EntityManagerFactoryGenerator.getInstance();

        //then
        System.out.println("[ EntityManagerFactory Singleton ] " + factory1.hashCode());
        System.out.println("[ EntityManagerFactory Singleton ] " + factory2.hashCode());
        Assertions.assertEquals(factory1, factory2);
    }
    
    /*
    *  [ 엔티티 매니저(EntityManager) ]
    *  엔티티 매니저는 엔티티를 저장하는 메모리 상의 데이터베이스를 관리하는 인스턴스이다.
    *  엔티티를 저장하고, 수정, 삭제, 조회하는 등의 엔티티와 관련된 모든 일을 한다.
    *  엔티티 매니저는 thread-safe하지 않기 때문에 동시성 문제가 발생할 수 있다.
    *  따라서 스레드 간 공유를 하지 않고, web의 경우 일반적으로 request scope와 일치시킨다.
    * */

    /*
    *  [ 영속성 컨텍스트(PersistenceContext) ]
    *  엔티티 매니저를 통해 엔티티를 저장하거나 조회하면 엔티티 매니저는 영속성 컨텍스트에 엔티티를 보관하고 관리한다.
    *  영속성 컨텍스트는 엔티티를 key-value 방식으로 저장하는 저장소이다.
    *  영속성 컨텍스트는 엔티티 매니저를 생성할 때 하나 만들어진다.
    *  그리고 엔티티 매니저를 통해서 영속성 컨텍스트에 접근할 수 있고, 또 관리할 수 있다.
    * */

    @Test
    @DisplayName("엔티티 매니저 생성 확인")
    void testGenerateEntityManager() {
        //given

        //when
        EntityManager manager = EntityManagerGenerator.getInstance();

        //then
        System.out.println("[ EntityManager Test ] " + manager.hashCode());
        Assertions.assertNotNull(manager);

    }

    @Test
    @DisplayName("엔티티 매니저 스코프 확인")
    void testEntityManagerLifeCycle() {
        //given
        EntityManager manager1 = EntityManagerGenerator.getInstance();

        //when
        EntityManager manager2 = EntityManagerGenerator.getInstance();

        //then
        System.out.println("[ EntityManager1 Scope ] " + manager1.hashCode());
        System.out.println("[ EntityManager2 Scope ] " + manager2.hashCode());
        Assertions.assertNotEquals(manager1, manager2);
    }
}
