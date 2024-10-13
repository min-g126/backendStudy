package com.ohgiraffers.section01.scope.sub01.singleton;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    /*
    *  [ Bean Scope ]
    * Spring bean이 생성될 때 생성되는 인스턴스의 범위를 의미한다.
    * - singleton : 하나의 인스턴스만 생성하고, 모든 bean이 해당 인스턴스를 공유하여 사용한다.
    * - prototype : 매번 새로운 인스턴스를 생성한다.
    * - request : HTTP 요청 처리 시마다 새로운 인스턴스를 생성하고, 요청 처리가 끝나면 폐기한다. (웹 어플리케이션 컨텍스트에만 해당)
    * - session : HTTP 세션 당 하나의 인스턴스를 생성하고, 세션이 종료되면 폐기한다. (웹 어플리케이션 컨텍스트에만 해당)
    * - application : ServletContext에 하나의 인스턴스를 생성하고, 종료되면 폐기한다. (웹 어플리케이션 컨텍스트에만 해당)
    * - websocket : WebSocket 연결마다 하나의 인스턴스를 생성하고, 종료되면 폐기한다. (웹 어플리케이션 컨텍스트에만 해당)
    * */

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);


        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println("[beanName] " + beanName);
        }

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);
        Product water = context.getBean("water", Beverage.class);

        /* 1. 첫 번째 손님이 쇼핑 카트를 꺼낸다. */
        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);

        /* 2. 붕어빵과 초코우유를 담는다. */
        cart1.addItem(carpBread);
        cart1.addItem(milk);

        System.out.println("[cart1 내용]" + cart1.getItems());

        /* 3. 두 번째 손님이 쇼핑 카트를 꺼낸다. */
        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);

        /* 4. 지리산암반수를 담는다. */
        cart2.addItem(water);

        System.out.println("[cart2 내용]" + cart2.getItems());

        System.out.println("[cart1 hashcode] " + cart1.hashCode());
        System.out.println("[cart2 hashcode] " + cart2.hashCode());

    }
}
