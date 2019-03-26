package com.privilege.dao.impl;

import com.privilege.dao.RolesDao;
import com.privilege.po.Roles;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class RolesDaoImpl implements RolesDao{
    private QueryRunner queryRunner= C3P0Util.getQueryRunner();
    @Override
    public List<Roles> SelectRoles() {
        String sql="select * from roles";
        List<Roles>rolesList=null;
        try {
            rolesList  = queryRunner.query(sql, new BeanListHandler <Roles>(Roles.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rolesList;
    }

    @Override
    public int addRoles(Roles roles) throws SQLException {
      String sql="insert into `roles` values(null,?,?)";
      int add=0;
        System.out.println(roles.getName());
        System.out.println(roles.getDescription());
      add = queryRunner.update(sql,roles.getName(),roles.getDescription());

      return add;
    }
}
