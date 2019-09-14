<%--
  Created by IntelliJ IDEA.
  User: ShenMouMou
  Date: 2019/9/14
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" width="65%" height="55%" border="1" cellspacing="0">
    <caption style="color: blue;font-size: 25px">添加客户</caption>
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>密码</th>
    </tr>
    <c:forEach items="${pageBean.pageData}" var="user" varStatus="v">
        <tr>

            <td>${v.count+(pageBean.currentPage-1)*5}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3">
            ${pageBean.currentPage}/${pageBean.totalPage} &nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/page?currentPage=1">首页</a>
                &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/page?currentPage=${pageBean.currentPage-1>1?pageBean.currentPage-1:1}">上一页</a>
                &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/page?currentPage=${pageBean.currentPage+1<pageBean.totalPage?pageBean.currentPage+1:pageBean.totalPage}">下一页</a>
                &nbsp;&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/page?currentPage=${pageBean.totalPage}">末页</a>

        </td>
    </tr>
</table>
</body>
</html>
