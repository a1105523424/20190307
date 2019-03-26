package com.privilege;

import com.privilege.po.Privileges;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner = C3P0Util.getQueryRunner();
        System.out.println(queryRunner);
        String sql="select * from \"privileges\"";
        List<Privileges> query = queryRunner.query(sql, new BeanListHandler<Privileges>(Privileges.class));
        for (Privileges p:query){
            System.out.println(p);
        }
    }
}
