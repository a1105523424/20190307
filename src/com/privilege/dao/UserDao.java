package com.privilege.dao;

import com.privilege.po.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    int login(String username,String password) throws SQLException;

    int addUser(User user) throws SQLException;

    int selename(String username) throws SQLException;

    List<User> selectUser();

    int uptapassword(String password,String username);
}
