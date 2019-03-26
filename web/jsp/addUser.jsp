<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<!--头部-->
<%@ include file="top.jsp"%>
<!--主体内容-->
<section class="publicMian">
    <%@ include file="left.jsp"%>
    <div class="right">
        <h1>添加用户</h1>
        <form method="post" action="/RolesServlet?choose=3">
            名称：<input type="text" name="name"><br>

            <br> 描述:
            <input type="text" name="description" id="">
            <br>
            <br> <input type="submit" value="提交">
        </form>
    </div>
</section>
<footer class="footer"> 版权归XXXX </footer>
<script src="../js/time.js"></script>
</body>
</html>
