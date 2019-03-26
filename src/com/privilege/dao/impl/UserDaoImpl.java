package com.privilege.dao.impl;

import com.privilege.dao.UserDao;
import com.privilege.po.User;
import com.privilege.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private QueryRunner queryRunner = C3P0Util.getQueryRunner();

    //获取C3P0的操作对象
    @Override
    public int login(String username, String password) {
        String sql = "select count(*) from \"users\" where \"username\"=? AND \"passwords\"=?";
        String count = null;
        try {

            count =queryRunner.query(sql, new ScalarHandler(1), username,password).toString().toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(count);
    }

    @Override
    public int addUser(User user) throws SQLException {
        String sql="insert into \"users\" values(roots.nextval,?,?,?)";
        int i=0;
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getNickname());
         i = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getNickname());
        return  i;
    }

    @Override
    public int selename(String username) throws SQLException {
        String sql="select count('id') from \"users\" where \"username\"=?";
        String i=null;
         i =queryRunner.query(sql, new ScalarHandler(), username).toString();
        return Integer.parseInt(i);
    }

    @Override
    public List<User> selectUser() {
        String sql="select * from users";
        List<User> query=null;
        try {
            query = queryRunner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int uptapassword(String password,String username) {
      String sql="update users set password=? where username=?";
        int updatepassword=0;
        System.out.println(password);
        System.out.println(username);
        try {
            updatepassword = queryRunner.update(sql,password,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatepassword;
    }

}


