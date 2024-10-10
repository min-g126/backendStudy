package com.ohgiraffers.section02.annotation.sub02.qualifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonFieldQualifier")
public class PokemonField {

    /*
    * @Qualifier 어노테이션은 여러 개의 bean 객체 중에서 특정 bean 객체를 이름으로 지정하는 어노테이션이다.
    * @Primary 어노테이션과 함께 쓰이는 경우, @Qualifier 어노테이션 설정이 우선된다.
    * */

    /* 1. 필드 주입 방식 */
//    @Autowired
//    @Qualifier("squirtle")
    private Pokemon pokemon;

    /* 2. 생성자 주입 방식 */
    @Autowired
    public PokemonField(@Qualifier("charmander") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        pokemon.attack();
    }
}
