package com.ohgiraffers.section01.insert;

import com.ohgiraffers.domain.entity.Menu;

import java.sql.Connection;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.*;

public class MenuRegistService {

    public void registMenu(Menu menu) {

        Connection con = getConnection();

        MenuRepository repository = new MenuRepository();
        int result = repository.insertMenu(con, menu);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);
    }
}
