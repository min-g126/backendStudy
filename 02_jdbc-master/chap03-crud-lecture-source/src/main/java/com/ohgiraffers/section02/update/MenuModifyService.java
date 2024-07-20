package com.ohgiraffers.section02.update;

import com.ohgiraffers.domain.entity.Menu;


import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuModifyService {

    public void modifyMenu(Menu menu) {

        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.updateMenu(con, menu);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }

}
