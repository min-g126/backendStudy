package com.ohgiraffers.section02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {

        /* xml 파일을 활용한 MyBatis 설정 */
        String resource = "mybatis-config.xml";


        try {
            /* Stream으로 설정 정보를 읽어와 SqlSessionFactory build */
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession session = sqlSessionFactory.openSession(false);

            /* sqlSessio의 selectOne 메소드로 'mapper.쿼리ID'를 수행하여 조회 결과 반환 */
            java.util.Date date = session.selectOne("mapper.selectSysdate");
            System.out.println(date);

            /* 사용한 자원 반납 */
            session.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
