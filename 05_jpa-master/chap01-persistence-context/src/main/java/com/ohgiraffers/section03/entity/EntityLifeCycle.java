package com.ohgiraffers.section03.entity;

import jakarta.persistence.EntityManager;

import java.util.Collection;

public class EntityLifeCycle {

    private EntityManager manager;

    public Menu findMenuByMenuCode(int menuCode) {

        manager = EntityManagerGenerator.getManagerInstance();
        return manager.find(Menu.class, menuCode);

    }

    public EntityManager getManagerInstance() {
        return manager;
    }
}
