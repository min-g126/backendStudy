package com.ohgiraffers.section01.lifecycle;

import static com.ohgiraffers.section01.lifecycle.Template.getSqlSession;

public class Application {

    public static void main(String[] args) {

        /* 애플리케이션이 작동하는 동안 sqlSessionFactory의 hashCode는 동일하지만,
        *  sqlSession은 호출 시마다 생성하므로 hashCode가 매번 다름.
        * */
        getSqlSession();
        getSqlSession();
        getSqlSession();
        getSqlSession();
        getSqlSession();


    }
}
