package com.privilege.controller;

import com.privilege.servlce.UserService;
import com.privilege.servlce.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    //获取服务层对象
    private UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //调

        int rows = 0;
        try {
            rows = userService.login(username,password);
            if (rows>0){
                //存
                HttpSession session =   request.getSession();
                session.setAttribute("username",username);
                //转
                request.getRequestDispatcher("/jsp/welcome.jsp").forward(request,response);
            }else{
                response.sendRedirect("login.jsp");

            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
