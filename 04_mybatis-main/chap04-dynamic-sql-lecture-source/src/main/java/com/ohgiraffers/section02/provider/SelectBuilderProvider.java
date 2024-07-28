package com.ohgiraffers.section02.provider;

import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.jdbc.SQL;

public class SelectBuilderProvider {

    public String selectAllMenu() {
        return new SQL()
                .SELECT("menu_code")
                .SELECT("menu_name")
                .SELECT("menu_price")
                .SELECT("category_code")
                .SELECT("orderable_Status")
                .FROM("tbl_menu")
                .WHERE("orderable_status = 'Y'")
                .toString();

    }

    public String searchMenuByCondition(SearchCriteria searchCriteria) {
        SQL sql = new SQL()
                .SELECT("menu_code", "menu_name", "menu_price", "category_code", "orderable_Status")
                .FROM("tbl_menu");
    }
}
