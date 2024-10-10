package com.ohgiraffers.section02.annotation.sub01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        PokemonField field = context.getBean("pokemonFieldPrimary", PokemonField.class);

        field.pokemonAttack();

    }
}
