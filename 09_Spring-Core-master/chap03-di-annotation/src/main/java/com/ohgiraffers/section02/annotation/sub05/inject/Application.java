package com.ohgiraffers.section02.annotation.sub05.inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        PokemonField pokemonField = context.getBean("pokemonFieldInject", PokemonField.class);

        pokemonField.pokemonAttack();

    }
}
