<%@ page import="com.yy.el.entry.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 雷思雅
  Date: 2024/8/26
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式</title>
</head>
<body>
<%--获取作用域中的值--%>
<%--传统方式获取值有一下缺点：
    1.需要导包
    2.类型的强制转换
    3.层次结构比较复杂
--%>
name:<%=request.getParameter("name")%><br>
pwd:<%=request.getParameter("pwd")%><br>
aaa:<%=request.getAttribute("name")%><br>
user:<%=request.getAttribute("user")%><br>
userName:<%=((User)request.getAttribute("user")).getName()%><br>
长沙：<%=((User)((ArrayList)request.getAttribute("list")).get(1)).getName()%>
map：<%=((Map)request.getAttribute("map")).get("aa")%>
<hr>
<%--el表达式--%>
name:${param.name}<br>
pwd:${param.pwd}<br>
aaa:${aaa}<br>
user:${user}<br>
userName:${user.name}<br>
长沙：${list[1].name}
map：${map.aa}
<hr>
<%--使用el表达式获取对象的顺序--%>
<%
    pageContext.setAttribute("key","hello page");
    request.setAttribute("key","hello req");
    session.setAttribute("key","hello session");
    application.setAttribute("key","hello application");
%>
key:${key}<br>
page:${pageScope.key}<br>
req:${requestScope.key}<br>
session:${sessionScope.key}<br>
application:${applicationScope.key}<br>
<hr>
<%--使用el表达式进行基本数据运算--%>
${1+10}<br>
${10>100}<br>
${1>10?"hhh":"aaa"}<br>
${1+"10"}<br>
<hr>
<%--获取请求头数据--%>
head:${header}<br>
headValue:${headerValues["cookie"][0]}<br>
param:${param}<br>
<%--获取cookie数据--%>
cookie:${cookie}<br>
${cookie.JSESSIONID}<br>
${cookie.JSESSIONID.name}<br>
${cookie.JSESSIONID.value}<br>
<hr>
<%--el表达式逻辑运算--%>
${true && false}<br>
${true || false}<br>
</body>
</html>
