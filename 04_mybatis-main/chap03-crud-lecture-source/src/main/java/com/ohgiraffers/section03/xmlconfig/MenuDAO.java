package com.ohgiraffers.section03.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    /* 해당 DAO에서 호출하는 이름(=MenuMapper)와 menu-mapper.xml의 namespace값(=MenuMapper)이 일치해야 한다.
     * */

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {
        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public MenuDTO selectMenuByCode(SqlSession sqlSession, int code) {
        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, int code) {
        return sqlSession.delete("MenuMapper.deleteMenu", code);
    }

}
