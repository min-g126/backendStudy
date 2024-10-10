package com.ohgiraffers.section02.annotation.sub03.collection;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("pokemonFieldCollection")
public class PokemonField {

    /* 1. List 타입으로 주입 */
    /*
    private List<Pokemon> pokemonList;

    @Autowired
    public PokemonField(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void pokemonAttack() {
        pokemonList.forEach(Pokemon::attack);
//        for (Pokemon pokemon : pokemonList) {
//            pokemon.attack();
//        }
    }
    */

    /* 2. Map 타입으로 주입 */

    private Map<String, Pokemon> pokemonMap;

    @Autowired
    public PokemonField(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    public void pokemonAttack() {
        pokemonMap.forEach((k, v) -> {
            System.out.println("key : " + k);
            System.out.print("공격 : ");
            v.attack();
        });
    }
}
