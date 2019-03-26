package com.privilege.servlce.impl;

import com.privilege.dao.PrivilegesDao;
import com.privilege.dao.impl.PrivilegesDaoImpl;
import com.privilege.po.Privileges;
import com.privilege.servlce.PrivilegeService;
import netscape.security.Privilege;

import java.util.List;

public class PrivilegeServiceImpl implements PrivilegeService {
    PrivilegesDao privilegesDao=new PrivilegesDaoImpl();


    @Override
    public List<Privileges> getPrivilegeList(int roleid) {
        return privilegesDao.getPrivilegeList(roleid);
    }

    @Override
    public List<Privileges> getPrivilegesList(int roleid) {

        return privilegesDao.getPrivilegesList(roleid);
    }

    @Override
    public List<Privileges> getAllprivilegesList() {
        return privilegesDao.getAllprivilegesList();
    }

    @Override
    public int deletePrivilegesByRoleid(String[] deleteroleids, int roleid) {
        return privilegesDao.deletePrivilegesByRoleid(deleteroleids,roleid);
    }

    @Override
    public int addPrivilegesByRoleid(String[] addroleids, int roleid) {
        return privilegesDao.addPrivilegesByRoleid(addroleids, roleid);
    }

    @Override
    public int addPrivilege(Privileges privileges) {
        return privilegesDao.addPrivilege(privileges);
    }
}
