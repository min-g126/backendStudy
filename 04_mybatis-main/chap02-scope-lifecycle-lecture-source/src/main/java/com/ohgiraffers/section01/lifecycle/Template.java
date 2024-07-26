package com.ohgiraffers.section01.lifecycle;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    /* SqlSessionFactory는 애플리케이션을 실행하는 동안 존재해야 하며,
    *  애플리케이션이 실행되는 동안 여러 차례 SqlSessionFactory를 다시 빌드하지 않는 것이 가장 좋은 형태이다.
    *  애플리케이션 스코프로 관리하기 위한 가장 간단한 방법은 싱글톤 패턴을 이용하는 것이다.
    * */

    private static SqlSessionFactory sqlSessionFactory;

    /* DB connection 정보를 static 필드로 선언 */
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menu";
    private static String USER = "sahmyook";
    private static String PASSWORD = "sahmyook";

    public static SqlSession getSqlSession() {

        if(sqlSessionFactory == null) {
            Environment environment = new Environment("dev",
                                                    new JdbcTransactionFactory(),
                                                    new PooledDataSource(DRIVER, URL, USER, PASSWORD));

            Configuration configuration = new Configuration(environment);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println("sqlSessionFactory의 hashCode() : " + sqlSessionFactory.hashCode());
        System.out.println("sqlSession의 hashCode() : " + sqlSession.hashCode());

        return sqlSession;
    }
}
