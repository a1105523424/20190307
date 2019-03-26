package com.privilege.dao;

import com.privilege.po.Roles;


import java.sql.SQLException;
import java.util.List;

public interface RolesDao {
    List<Roles>SelectRoles();
    int addRoles(Roles roles) throws SQLException;
}
