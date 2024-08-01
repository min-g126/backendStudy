package com.ohgiraffers.association.section01.manytoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ManyToOneRepository {

    @PersistenceContext
    private EntityManager manager;

    public Menu find(int menuCode) {
        return manager.find(Menu.class, menuCode);
    }

    /*
    * [ JPQL (Java Persistence Query Language) ]
    * - 객체 지향 쿼리 언어 중 하나이다.
    * - 객체 지향 모델에 맞게 작성된 쿼리를 통해 엔티티를 대상으로 검색하고, 검색 결과를 토대로 객체를 조작할 수 있다.
    * - join 문법이 sql과는 다소 차이가 있지만 직접 쿼리를 작성할 수 있는 문법을 제공한다.
    * - 주의할 점은 FROM절에 기술할 테이블명에는 반드시 엔티티명을 작성해야 한다.
    * */
    public String findCategoryName(int menuCode) {
        String jpql = "SELECT c.categoryName" +
                    " FROM menu_and_category m" +
                    " JOIN m.category c" +
                    " WHERE m.menuCode = :menuCode";

        return manager.createQuery(jpql, String.class)
                    .setParameter("menuCode", menuCode)
                    .getSingleResult();
    }

    public void regist(Menu menu) {
        manager.persist(menu);
    }
}
