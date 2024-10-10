package com.ohgiraffers.section02.annotation.sub03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        PokemonField pokemonField = context.getBean("pokemonFieldCollection", PokemonField.class);

        pokemonField.pokemonAttack();
    }
}
