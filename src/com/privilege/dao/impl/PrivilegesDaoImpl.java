package com.privilege.dao.impl;

import com.privilege.dao.PrivilegesDao;
import com.privilege.po.Privileges;
import com.privilege.utils.C3P0Util;
import netscape.security.Privilege;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class PrivilegesDaoImpl implements PrivilegesDao {
    private QueryRunner queryRunner= C3P0Util.getQueryRunner();


    @Override
    public List<Privileges> getPrivilegeList(int roleid) {
        String sql="select * from `privileges` where id  in(select privilege_id from roleprivilege where role_id =?)";
        List<Privileges>privilegeList=null;
        try {
            privilegeList = queryRunner.query(sql,new BeanListHandler<Privileges>(Privileges.class),roleid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privilegeList;
    }

    @Override
    public List<Privileges> getPrivilegesList(int roleid) {
        String sql="select * from `privileges` where id not in(select privilege_id from roleprivilege where role_id=?)";
        List<Privileges>privilegesList=null;
        try {
            privilegesList=queryRunner.query(sql,new BeanListHandler<Privileges>(Privileges.class),roleid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privilegesList;


    }
    @Test
    @Override
    public List<Privileges> getAllprivilegesList() {
       String sql="select * from \"privileges\"";
    List<Privileges>privilegesList=null;
        try {
            privilegesList= queryRunner.query(sql,new BeanListHandler<Privileges>(Privileges.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;

        return privilegesList;
    }

    @Override
    public int deletePrivilegesByRoleid(String[] deleteroleids,int roleid) {
        int deid=0;
       String sql="delete from roleprivilege where privilege_id=? and role_id="+roleid;
           try {
               for(int i=0;i<deleteroleids.length;i++) {

               deid = queryRunner.update(sql,deleteroleids[i]);

           }
           } catch (SQLException e) {
               e.printStackTrace();
           }

        return deid;
    }

    @Override
    public int addPrivilegesByRoleid(String[] addroleids,int roleid) {
        int addid=0;
        String sql="insert into roleprivilege values(?,?)";
        try {
            for(int i=0;i<addroleids.length;i++) {
                System.out.println(addroleids[i]);
                addid = queryRunner.update(sql,addroleids[i],roleid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addid;
    }

    @Override
    public int addPrivilege(Privileges privileges) {
        String sql="insert into `privileges` values(null,?,?,?)";
        int add=0;
        try {
           add=queryRunner.update(sql,privileges.getName(),privileges.getFnpath(),privileges.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return add;
    }
}

