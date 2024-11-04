package com.ohgiraffers.transactional.annotation;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int registOrder(Order order);

    int registOrderMenu(OrderMenu orderMenu);
}
