<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/9 0009
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
<form method="post" action="/RigireServlet?choose=1">
账号<input type="text" name="username"><br>
密码<input type="text" name="password"><br>
管理员<input type="text" name="nikename"><br>
<input type="submit" value="提交">
</form>
</body>
</html>
