package com.ohgiraffers.mybatisspring.factorybean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuServiceTests {

    @Autowired
    private MenuService menuService;

    @Test
    void testFindAllMenus() {
        Assertions.assertDoesNotThrow(
                () -> {
                    List<MenuDTO> menus = menuService.findAllMenus();
                    menus.forEach(System.out::println);
                }
        );
    }
}
