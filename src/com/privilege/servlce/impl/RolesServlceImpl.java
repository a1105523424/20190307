package com.privilege.servlce.impl;

import com.privilege.dao.RolesDao;
import com.privilege.dao.impl.RolesDaoImpl;
import com.privilege.po.Roles;
import com.privilege.servlce.RolesServlce;

import java.sql.SQLException;
import java.util.List;

public class RolesServlceImpl implements RolesServlce {
    RolesDao rolesDao = new RolesDaoImpl();

    @Override
    public List<Roles> SelectRoles() {
        return rolesDao.SelectRoles();
    }

    @Override
    public int addRoles(Roles roles) throws SQLException {
        return  rolesDao.addRoles(roles);
    }
}


