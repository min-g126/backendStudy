package com.ohgiraffers.section02.annotation.sub01.primary;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonFieldPrimary")
public class PokemonField {

    private Pokemon pokemon;

    @Autowired
    public PokemonField(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
