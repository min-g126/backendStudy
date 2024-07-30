package com.ohgiraffers.section02.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Collection;


public class EntityManagerCRUD {

    private EntityManager manager;

    public Menu findMenuByMenuCode(int menuCode) {
        manager = EntityManagerGenerator.getManagerInstance();
        return manager.find(Menu.class, menuCode);
    }

    public Long saveAndReturnAllCount(Menu newMenu) {
        manager = EntityManagerGenerator.getManagerInstance();

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.persist(newMenu);
        manager.flush();

//        transaction.commit();

        return getCount(manager);
    }

    private Long getCount(EntityManager manager) {
        return manager.createQuery("SELECT COUNT(*) FROM Section02Menu", Long.class).getSingleResult();
    }

    public EntityManager getManagerInstance() {
        return manager;
    }

    public Menu modifyMenuName(int menuCode, String menuName) {
        Menu foundMenu = findMenuByMenuCode(menuCode);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        foundMenu.setMenuName(menuName);
        manager.flush();


        return foundMenu;
    }


    public Long removeAndReturnAllCount(int menuCode) {
        Menu foundMenu = findMenuByMenuCode(menuCode);

        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        manager.remove(foundMenu);
        manager.flush();

        return getCount(manager);
    }
}
