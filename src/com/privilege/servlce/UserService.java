package com.privilege.servlce;

import com.privilege.po.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public interface UserService {
    int login(String username,String password) throws SQLException, UnsupportedEncodingException, NoSuchAlgorithmException;

    int addUser(User user) throws SQLException;

    int selename(String username) throws SQLException;

    List<User> selectUser();

    int uptapassword(String password,String username);
}
