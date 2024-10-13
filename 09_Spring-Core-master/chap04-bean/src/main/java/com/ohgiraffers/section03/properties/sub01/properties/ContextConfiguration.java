package com.ohgiraffers.section03.properties.sub01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("section03/properties/sub01/properties/product-info.properties")
public class ContextConfiguration {

    @Value("${bread.carpbread.name:팥붕어빵}")
    private String carpBreadName;

//    @Value("${bread.carpbread.name:슈크림붕어빵}")
//    private String carpBreadName2;

    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;

    @Value("${beverage.milk.name}")
    private String milkName;

    @Value("${beverage.milk.price}")
    private int milkPrice;

    @Value("${beverage.milk.capacity}")
    private int milkCapacity;


    @Bean
    public Product carpBread() {
//        System.out.println(carpBreadName2);
        return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    public Product water(
            @Value("${beverage.water.name}") String waterName,
            @Value("${beverage.water.price}") int waterPrice,
            @Value("${beverage.water.capacity}") int waterCapacity
    ) {
        return new Beverage(waterName, waterPrice, waterCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
