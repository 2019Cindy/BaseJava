<%--
  Created by IntelliJ IDEA.
  User: 雷思雅
  Date: 2024/8/28
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%--
    jstl:在jsp页面中添加复杂的逻辑判断，避免逻辑代码和页面标签混为一谈。jstl是el的扩展，
    jstl 的导入：<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    标签分类：
        ***核心标签库：
        **格式化标签库：
        *函数标签库：
        *XML标签库：
        *SQL标签库：
    常见标签：
        1.<c:out value="hhhh"></c:out>：输出标签
            value：要输出的值，default：默认值
        2.<c:set var="java" value="pageContext"></c:set>,向作用域设置属性值
            var 表示参数的key，value表示参数的值，scope表示向哪个作用域设置值
        3.<c:remove var="java"></c:remove>，删除作用域中的数据
            var 表示参数的key，scope表示参数作用的范围（如果没有指定scope，默认会将所有作用域中的参数删除）
        4.<c:if test="${a>5}"><h4>jstl is easy!</h4></c:if>,逻辑判断

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
<%
    request.setAttribute("str", "str");
%>
<c:out value="hhhh" default="呼呼呼"></c:out><br>
<c:out value="${str11}" default="呼呼呼"></c:out><br>

<%--向作用域设置属性值--%>
<c:set var="java" value="pageContext" scope="page"></c:set>
<c:set var="java" value="request" scope="request"></c:set>
<c:set var="java" value="session" scope="session"></c:set>
<c:set var="java" value="application" scope="application"></c:set>
<c:out value="${pageScope.java}"></c:out><br>
<c:out value="${requestScope.java}"></c:out><br>
<c:out value="${sessionScope.java}"></c:out><br>
<c:out value="${applicationScope.java}"></c:out><br>
<hr>
<%--删除作用域的数据--%>
<c:remove var="java" scope="page"></c:remove>
<c:out value="${java}"></c:out><br>
<c:out value="${requestScope.java}"></c:out><br>
<hr>
<%--逻辑判断标签--%>
<%--<c:set var="a" value="10"></c:set>--%>
<%--<c:if test="${a>5}">--%>
<%--    <h4>jstl is easy!</h4>--%>
<%--</c:if>--%>
<%--<c:set var="age" value="200"></c:set>--%>
<%--<c:choose>--%>
<%--    <c:when test="${age>110}">--%>
<%--        <h4>老年人</h4>--%>
<%--    </c:when>--%>
<%--&lt;%&ndash;    <c:when test="${age>30}">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <h4>牛马</h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </c:when>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <c:when test="${age<20}">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <h4>儿童</h4>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </c:when>&ndash;%&gt;--%>
<%--</c:choose>--%>
</body>
</html>
