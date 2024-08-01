package com.ohgiraffers.association.section03.bidirection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class BiDirectionRepository {

    @PersistenceContext
    private EntityManager manager;

    public Menu findMenu(int menuCode) {
        return manager.find(Menu.class, menuCode);
    }

    public Category findCategory(int categoryCode) {
        return manager.find(Category.class, categoryCode);
    }

    public void saveMenu(Menu menu) {
        manager.persist(menu);
    }

    public void saveCategory(Category category) {
        manager.persist(category);
    }
}
