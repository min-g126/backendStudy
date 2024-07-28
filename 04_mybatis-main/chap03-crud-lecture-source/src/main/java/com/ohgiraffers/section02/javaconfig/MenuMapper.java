package com.ohgiraffers.section02.javaconfig;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MenuMapper {

    @Results(id="menuResultMap", value = {
            @Result(id = true, property = "code", column = "menu_code"),
            @Result(property = "name", column = "menu_name"),
            @Result(property = "price", column = "menu_price"),
            @Result(property = "categoryCode", column = "category_code"),
            @Result(property = "orderableStatus", column = "orderable_status")
    })
    @Select("SELECT menu_code, menu_name, menu_price, category_code, orderable_status\n" +
            "  FROM tbl_menu\n" +
            " WHERE orderable_status = 'Y'\n" +
            "ORDER BY menu_code")
    List<MenuDTO> selectAllMenu();

    @Select("SELECT menu_code, menu_name, menu_price, category_code, orderable_status\n" +
            "  FROM tbl_menu\n" +
            " WHERE menu_code = #{ code }")
    @ResultMap("menuResultMap")         // 위에서 사용한 resultMap 재사용 가능
    MenuDTO selectMenuByCode(int code);

    @Insert("INSERT INTO tbl_menu(\n" +
            "                       menu_name\n" +
            "                       , menu_price\n" +
            "                       , category_code\n" +
            "                       , orderable_status\n" +
            "                   )\n" +
            "VALUES (\n" +
            "       #{ name }\n" +
            "       , #{ price }\n" +
            "       , #{ categoryCode }\n" +
            "       , 'Y'\n" +
            ")")
    int insertMenu(MenuDTO menu);

    @Update("UPDATE tbl_menu\n" +
            "   SET menu_name = #{ name }\n" +
            "       , menu_price = #{ price }\n" +
            " WHERE menu_code = #{ code }")
    int updateMenu(MenuDTO menu);

    @Delete("DELETE\n" +
            "  FROM tbl_menu\n" +
            " WHERE menu_code = #{ code }")
    int deleteMenu(int code);

}
