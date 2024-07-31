package com.ohgiraffers.mapping.section01.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager manager;

    public void save(Member member) {

        manager.persist(member);
    }


    public String findNameById(String memberId) {
        String jpql = "SELECT m.memberName FROM entityMember m WHERE m.memberId = '" + memberId + "'";
        return manager.createQuery(jpql, String.class).getSingleResult();
    }
}
