package com.privilege.servlce;

import com.privilege.po.Privileges;
import netscape.security.Privilege;

import java.util.List;

public interface PrivilegeService {
    List<Privileges> getPrivilegeList(int roleid);
    List<Privileges> getPrivilegesList(int roleid);
    List<Privileges> getAllprivilegesList();

    int deletePrivilegesByRoleid(String[] deleteroleids,int roleid);
    int addPrivilegesByRoleid(String [] addroleids,int roleid);

    int addPrivilege(Privileges privileges);
}
