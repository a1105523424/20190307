package com.privilege.servlce;

import com.privilege.po.Roles;

import java.sql.SQLException;
import java.util.List;

public interface RolesServlce {
    List<Roles> SelectRoles();

    int addRoles(Roles roles)throws SQLException;
}
