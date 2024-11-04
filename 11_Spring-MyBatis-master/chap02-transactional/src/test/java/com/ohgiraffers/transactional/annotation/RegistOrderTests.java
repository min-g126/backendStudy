package com.ohgiraffers.transactional.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;


@SpringBootTest
@Transactional
public class RegistOrderTests {

    @Autowired
    private RegistOrderService registOrderService;

    private static Stream<Arguments> getOrderInfo() {
        OrderDTO orderInfo = new OrderDTO();
        orderInfo.setOrderDate(LocalDate.now());
        orderInfo.setOrderTime(LocalTime.now());

        /*
        List<OrderMenuDTO> orderMenuList = new ArrayList<>();
        orderMenuList.add(new OrderMenuDTO(1, 10));
        orderMenuList.add(new OrderMenuDTO(2, 5));
        orderInfo.setOrderMenus(orderMenuList);
        */

        orderInfo.setOrderMenus(
                List.of(
                        new OrderMenuDTO(1, 10),
                        new OrderMenuDTO(2, 5)
                )
        );

        return Stream.of(
                Arguments.of(orderInfo)
        );




    }

    @DisplayName("주문 등록 테스트")
    @ParameterizedTest
    @MethodSource("getOrderInfo")
    void testRegistNewOrder(OrderDTO orderInfo) {
        Assertions.assertDoesNotThrow(
                () -> registOrderService.registNewOrder(orderInfo)
        );

    }
}
