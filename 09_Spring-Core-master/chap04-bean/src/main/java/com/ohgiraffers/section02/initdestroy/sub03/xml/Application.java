package com.ohgiraffers.section02.initdestroy.sub03.xml;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new GenericXmlApplicationContext("section02/initdestroy/sub03/xml/spring-context.xml");


        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("[cart1 내용]" + cart1.getItems());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);

        cart2.addItem(water);

        System.out.println("[cart2 내용]" + cart2.getItems());

        ((GenericXmlApplicationContext) context).close();
    }

}
