package com.privilege.servlce.impl;

import com.privilege.dao.UserDao;
import com.privilege.dao.impl.UserDaoImpl;
import com.privilege.po.User;
import com.privilege.servlce.UserService;
import com.privilege.utils.MD5Util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public int login(String username, String password) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //MD5加密
        password= MD5Util.MD5Encoding(password);
        System.out.println(password);
        //调用dao层login方法
        int rows = userDao.login(username, password);

        return rows;
    }

    @Override
    public int addUser(User user) throws SQLException {
        String password = MD5Util.MD5Encoding(user.getPassword());
        System.out.println(password);
        return  userDao.addUser(user);

    }

    @Override
    public int selename(String username) throws SQLException {
        return userDao.selename(username);
    }

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }

    @Override
    public int uptapassword(String password,String username) {
        password = MD5Util.MD5Encoding(password);
        System.out.println(password);
        return  userDao.uptapassword(password,username);
    }
}
