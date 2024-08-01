package com.ohgiraffers.association.section03.bidirection;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "bidirection_category")
@Table(name = "tbl_category")
public class Category {

    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    /*
    * [ mappedBy ]
    * 객체의 참조는 둘인데 외래키는 하나인 상황을 해결하기 위해
    * 두 객체의 연관관계 중 하나를 정해서 테이블의 외래키를 관리하는데
    * 이를 연관관계의 주인(Owner)이라고 한다.
    * 연관관계의 주인은 mappedBy 속성을 사용하지 않는다.
    *
    * 연관관계의 주인이 아닌 객체에 mappedBy 속성을 설정함으로써 N:1이나 1:N 관계에서
    * 다(N)에 해당하는 연관관계의 주인은 테이블에서 외래키가 있는 곳으로 정해야 하지만,
    * 반대로 설정하는 것도 가능은 하다. (하지만 성능상 권장하지 않는다.)
    * */

    @OneToMany(mappedBy = "category")
    private List<Menu> menuList;

    protected Category() {}

    public Category(int categoryCode, String categoryName, Integer refCategoryCode) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
    }

    public Category(int categoryCode, String categoryName, Integer refCategoryCode, List<Menu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
//                ", menuList=" + menuList +
                '}';
    }
}
