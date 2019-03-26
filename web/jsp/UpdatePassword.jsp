<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>修改密码</title>
</head>
<body>
<!--头部-->
<%@ include file="top.jsp"%>
<!--主体内容-->
<section class="publicMian">
    <%@ include file="left.jsp"%>
    <div class="right">
        <h1>添加权限</h1>
        <form method="post" action="/RigireServlet?choose=3">
            名称：<input name="username"><br>
            <br> 旧密码:<input name=""><br>
            <br> 新密码:<input name="password">

            <br>
            <br> <input type="submit" value="提交">
        </form>
    </div>
</section>
<footer class="footer"> 版权归XXXX </footer>
<script src="../js/time.js"></script>
</body>
</html>