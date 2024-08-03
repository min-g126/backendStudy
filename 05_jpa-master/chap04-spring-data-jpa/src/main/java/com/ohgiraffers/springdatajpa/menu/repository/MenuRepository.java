package com.ohgiraffers.springdatajpa.menu.repository;

import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    /* 전달받은 가격을 초과하는 메뉴의 목록을 조회하는 메소드 */
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice);

    /* 전달받은 가격을 초과하는 메뉴의 목록을 가격순으로 조회하는 메소드 */
    List<Menu> findByMenuPriceGreaterThanOrderByMenuPrice(Integer menuPrice);

    /* 전달받은 가격을 초과하는 메뉴의 목록을 전달받은 정렬 기준으로 조회하는 메소드 */
    List<Menu> findByMenuPriceGreaterThan(Integer menuPrice, Sort sort);

}
