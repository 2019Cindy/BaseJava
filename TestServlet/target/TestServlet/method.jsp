<%--
  Created by IntelliJ IDEA.
  User: 雷思雅
  Date: 2024/8/11
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>method</title>
</head>
<body>
    <form action="response" method="post">
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="pwd"><br>
        爱好：<input type="checkbox" name="fun" value="1">吃饭
        <input type="checkbox" name="fun" value="2">睡觉
        <input type="checkbox" name="fun" value="3">打豆豆
        <input type="submit" value="登录">
    </form>
</body>
</html>
