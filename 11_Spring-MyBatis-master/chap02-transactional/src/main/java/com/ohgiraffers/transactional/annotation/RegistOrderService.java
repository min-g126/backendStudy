package com.ohgiraffers.transactional.annotation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RegistOrderService {

    private MenuMapper menuMapper;

    private OrderMapper orderMapper;

    public RegistOrderService(MenuMapper menuMapper, OrderMapper orderMapper) {
        this.menuMapper = menuMapper;
        this.orderMapper = orderMapper;
    }

    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void registNewOrder(OrderDTO orderInfo) {

        List<Integer> menuCodes = orderInfo.getOrderMenus()
                                            .stream()
                                            .map(OrderMenuDTO::getMenuCode)
                                            .collect(Collectors.toList());

        /*
        List<Integer> menuCodes = new ArrayList<>();
        for (int i = 0; i < orderInfo.getOrderMenus().size(); i++) {
            menuCodes.add(orderInfo.getOrderMenus().get(i).getMenuCode());
        }
        */

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("menuCodes", menuCodes);

        List<Menu> menus = menuMapper.findMenusByMenuCode(map);
        System.out.println("================== menus ==================");
        System.out.println(menus);

        int totalOrderPrice = calcTotalOrderPrice(orderInfo.getOrderMenus(), menus);
        System.out.println("[totalOrderPrice] : " + totalOrderPrice);

        /*
        List<OrderMenu> orderMenus = new ArrayList<>();
        for (int i = 0; i < orderInfo.getOrderMenus().size(); i++) {
            OrderMenuDTO orderMenuDTO = orderInfo.getOrderMenus().get(i);
            OrderMenu orderMenu = new OrderMenu(orderMenuDTO.getMenuCode(), orderMenuDTO.getOrderAmount());
            orderMenus.add(orderMenu);
        }
        */


        List<OrderMenu> orderMenus = new ArrayList<>(
                orderInfo.getOrderMenus().stream()
                        .map(dto -> {
                            return new OrderMenu(dto.getMenuCode(), dto.getOrderAmount());
                        }).collect(Collectors.toList())
        );
        System.out.println("================== orderMenus ===============");
        for (OrderMenu orderMenu : orderMenus) {
            System.out.println(orderMenu);
        }

        Order order = new Order(orderInfo.getOrderDate(), orderInfo.getOrderTime(), totalOrderPrice);
        System.out.println("================== order =================");
        System.out.println(order);

        orderMapper.registOrder(order);
        System.out.println("[after insert] : " + order);

        for (OrderMenu orderMenu : orderMenus) {
            orderMenu.setOrderCode(order.getOrderCode());
            orderMapper.registOrderMenu(orderMenu);
        }
    }

    private int calcTotalOrderPrice(List<OrderMenuDTO> orderMenus, List<Menu> menus) {

        int totalOrderPrice = 0;

        int orderMenuSize = orderMenus.size();
        for (int i = 0; i < orderMenuSize; i++) {
            OrderMenuDTO orderMenu = orderMenus.get(i);
            Menu menu = menus.get(i);
            totalOrderPrice += menu.getMenuPrice() * orderMenu.getOrderAmount();
        }

        return totalOrderPrice;
    }


}
