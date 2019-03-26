package com.privilege.controller;

import com.alibaba.fastjson.JSONObject;
import com.privilege.po.Privileges;
import com.privilege.servlce.PrivilegeService;
import com.privilege.servlce.impl.PrivilegeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/PrivilegesServlet")
public class PrivilegesServlet extends HttpServlet {
   private PrivilegeService privilegeService=new PrivilegeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choose = request.getParameter("choose");

        switch (choose){
            case "1":
                AddPs(request,response);
            break;
            case "2":
                SelectPs(request,response);
                break;
            case "3":
                toPrivilege(request,response);
                default:
                    break;
        }


    }

    private void toPrivilege(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int roleid = Integer.parseInt(request.getParameter("roleid"));

        String[] privilegedeletes = request.getParameter("privilegedeleteid").split(",");
        String[] privilegeadds = request.getParameter("privilegeaddid").split(",");

        //调方法

        int delrows = privilegeService.deletePrivilegesByRoleid(privilegedeletes, roleid);
        int adds=privilegeService.addPrivilegesByRoleid(privilegeadds,roleid);

        if(delrows>0&&adds>0){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("result",1);
            String s = jsonObject.toJSONString(jsonObject);
            PrintWriter writer = response.getWriter();
            writer.write(s);
            writer.flush();
            writer.close();


        }



    }

    private void SelectPs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Privileges>privilegesList=privilegeService.getAllprivilegesList();
        if(privilegesList.size()>0){
            HttpSession session=request.getSession();
            session.setAttribute("privilegesList",privilegesList);
            request.getRequestDispatcher("jsp/privilege_list.jsp").forward(request,response);

        }
    }

    private void AddPs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_name = request.getParameter("p_name");
        String p_url = request.getParameter("p_url");
        String p_description = request.getParameter("p_description");

        Privileges privileges=new Privileges(0,p_name,p_url,p_description);
        System.out.println(privileges.toString());
        int row=privilegeService.addPrivilege(privileges);

       if(row>0){
           request.getRequestDispatcher("/jsp/select.jsp").forward(request,response);

       }else {
           System.out.println(row);
       }


    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
