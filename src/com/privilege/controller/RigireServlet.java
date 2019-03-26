package com.privilege.controller;

import com.privilege.po.User;
import com.privilege.servlce.UserService;
import com.privilege.servlce.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/RigireServlet")
public class RigireServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choose = request.getParameter("choose");

        switch (choose) {
            case "1":
                try {
                    Rigin(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "2":
                selectU(request,response);
                break;
            case "3":
                utdateP(request,response);
                default:
                    break;
        }
    }

    private void utdateP(HttpServletRequest request, HttpServletResponse response) {
        User user=new User();
            String password=request.getParameter("password");
            String username = request.getParameter("username");

        int uptapassword = userService.uptapassword(password,username);
        System.out.println(password);
        System.out.println(username);
        if(uptapassword>0){
            try {
                request.getRequestDispatcher("/jsp/select.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(uptapassword);
        }



    }

    private void selectU(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.selectUser();

        HttpSession session=request.getSession();
        session.setAttribute("usersList",users);
        System.out.println(users.toString());
        try {
            request.getRequestDispatcher("jsp/select.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void Rigin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String nikename=request.getParameter("nikename");
        int selename = userService.selename(username);
        if(selename>0){
            try {
                request.getRequestDispatcher("jsp/select.jsp").forward(request,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nikename);
            System.out.println(username);
            System.out.println(password);
            System.out.println(nikename);
            int add=userService.addUser(user);

            if (add>0){
                try {
                    request.getRequestDispatcher("/jsp/Rigin.jsp").forward(request,response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println(add);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

}
