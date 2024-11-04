package com.ohgiraffers.transactional.annotation;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {

    List<Menu> findMenusByMenuCode(Map<String, List<Integer>> map);
}
