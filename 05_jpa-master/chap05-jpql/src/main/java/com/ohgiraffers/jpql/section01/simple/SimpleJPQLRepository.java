package com.ohgiraffers.jpql.section01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SimpleJPQLRepository {

    @PersistenceContext
    private EntityManager manager;

    public Menu findMenu(int menuCode) {
        return manager.find(Menu.class, menuCode);
    }

    public String selectSingleMenuByTypedQuery() {
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        TypedQuery<String> query = manager.createQuery(jpql, String.class);
        String resultMenuName = query.getSingleResult();

        return resultMenuName;
    }

    public Object selectSingleMenuByQuery() {
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = 8";
        Query query = manager.createQuery(jpql);
        Object resultMenuName = query.getSingleResult();

        return resultMenuName;
    }

    public Menu selectSingleRowByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuCode = 8";
        TypedQuery<Menu> query = manager.createQuery(jpql, Menu.class);
        Menu resultMenu = query.getSingleResult();

        return resultMenu;
    }

    public List<Menu> selectMultipleRowByTypedQuery() {
        String jpql = "SELECT m FROM Section01Menu m";
        TypedQuery<Menu> query = manager.createQuery(jpql, Menu.class);
        List<Menu> resultMenuList = query.getResultList();

        return resultMenuList;
    }

    public List<Menu> selectMultipleRowByQuery() {
        String jpql = "SELECT m FROM Section01Menu m";
        Query query = manager.createQuery(jpql);
        List<Menu> resultMenuList = query.getResultList();

        return resultMenuList;
    }

    public List<Integer> selectUsingDistinct() {
        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu m";
        TypedQuery<Integer> query = manager.createQuery(jpql, Integer.class);
        List<Integer> resultCategoryList = query.getResultList();

        return resultCategoryList;
    }

    public List<Menu> selectUsingIn() {
        String jpql = "SELECT m FROM Section01Menu m WHERE m.categoryCode IN (11, 15)";
        List<Menu> resultMenuList = manager.createQuery(jpql, Menu.class).getResultList();

        return resultMenuList;
    }

    public List<Menu> selectUsingLike() {
        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuName LIKE '%마%'";
        List<Menu> resultMenuList = manager.createQuery(jpql, Menu.class).getResultList();

        return resultMenuList;
    }
}
