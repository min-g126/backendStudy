package com.ohgiraffers.section02.annotation.sub04.resource;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("pokemonFieldResource")
public class PokemonField {

    /* @Autowired 스프링 어노테이션은 type으로 의존성 주입을 하지만,
    * @Resource 어노테이션은 name 속성 값으로 의존성 주입을 할 수 있다. */
    /*
    @Resource(name = "pikachu")
    private Pokemon pokemon;

    public void pokemonAttack() {
        pokemon.attack();
    }
    */


    /* name 속성이 없을 경우 Type을 통해 의존성 주입한다. */
    @Resource
    private List<Pokemon> pokemonList;

    public void pokemonAttack() {
        pokemonList.forEach(Pokemon::attack);
    }
}
