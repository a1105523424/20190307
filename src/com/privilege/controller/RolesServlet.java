package com.privilege.controller;

import com.privilege.dao.PrivilegesDao;
import com.privilege.po.Privileges;
import com.privilege.po.Roles;
import com.privilege.servlce.PrivilegeService;
import com.privilege.servlce.RolesServlce;
import com.privilege.servlce.impl.PrivilegeServiceImpl;
import com.privilege.servlce.impl.RolesServlceImpl;
import netscape.security.Privilege;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/RolesServlet")
public class RolesServlet extends HttpServlet {
    private RolesServlce rolesServlce=new RolesServlceImpl();
    private PrivilegeService privilegeService=new PrivilegeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //取
        String choose = request.getParameter("choose");
        switch (choose){
            case  "1":
                SelectRolesList(request,response);
             break;
            case "2":
                selectprivilege(request,response);
                break;
            case "3":
                try {
                    Addroles(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
             default:
                 System.out.println("操作有问题");
                 break;
        }

    }

    private void Addroles(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name=request.getParameter("name");
        String description = request.getParameter("description");

        Roles roles=new Roles();
        roles.setName(name);
        roles.setDescription(description);

        int adds=rolesServlce.addRoles(roles);

        if(adds>0){

                request.getRequestDispatcher("/jsp/select.jsp").forward(request,response);
        }else{
            System.out.println(adds);
        }
    }

    //调用查询权限
    private void selectprivilege(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收角色名称
        String rolename = request.getParameter("rolename");
        int roleid = Integer.parseInt(request.getParameter("roleid"));
        List<Privileges>privilegeList=privilegeService.getPrivilegeList(roleid);
        List<Privileges> privilegesList=privilegeService.getPrivilegesList(roleid);
        //调用根据roleid查询权限的方法
        HttpSession session=request.getSession();
        session.setAttribute("privilegeList",privilegeList);
        session.setAttribute("privilegesList",privilegesList);
        session.setAttribute("roleid",roleid);
        System.out.println(roleid);
        request.getRequestDispatcher("/jsp/grant_privilege.jsp").forward(request,response);

    }

    private void SelectRolesList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调
        List<Roles> rolesList = rolesServlce.SelectRoles();
        //查
        HttpSession session=request.getSession();
        //转
        session.setAttribute("rolesList",rolesList);
        request.getRequestDispatcher("/jsp/roles_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
