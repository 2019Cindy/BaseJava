<%--
  Created by IntelliJ IDEA.
  User: 雷思雅
  Date: 2024/8/24
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%--
    page标签：用来设置转译成servlet文件时的参数
        contentType：表示浏览器解析响应信息时使用的编码及格式
        language：表示jsp转义的文件类型
        import：导入需要的jar包，多个包使用逗号分隔
        pageEncoding:设置页面的编码格式
        session:用于控制servlet中是否有session对象
        errorPage:当界面发生逻辑错误的时候，跳转的界面
--%>

<%--
    jsp中嵌入Java代码：
        局部代码块：将Java代码和页面展示的标签写道一个jsp代码中，在jsp转译成servlet的代码中，Java代码是在service方法中的
        缺点：可读性差，一般不使用

        全局代码块：定义公共的方法的时候，需要使用全局代码块<%!%>，转义后生成的代码在servlet类中，调用的时候需要使用局部代码块

        脚本调用方式：使用<%=变量或方法（方法必须要有返回值）%>
            注意：不能在变量或方法的后面添加分号
--%>

<%--
    页面导入的方式：
        静态导入：<%@include file="staticImport.jsp"%>,file中填写的是文件的相对路径
            不会将静态导入的页面生成一个新的servlet文件，将两个文件进行合并
            优点：运行块，缺点：两个界面会耦合在一起，不利于维护（多个界面中不能存在相同名的变量）
        动态导入：<jsp:include page="dynamicImport.jsp"></jsp:include>,两个界面不会合并，分别生成自己的servlet文件
            优点：没有耦合
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page session="true" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>page</title>
</head>
<body>
<%!
    public void test() {
        System.out.println("我是全局代码块！");
    }

    public String aa() {
        return "aa";
    }
    String bb="狗刚";
%>
page标签解析
<%
    int res = 10 / 5;
%>
<%
    int i = new Random().nextInt(10);
    if (i > 5) {
%>
<h4>天气很好！</h4>
<%
    }
    test();
%>
<%=bb%>

<%@include file="staticImport.jsp"%>
<jsp:include page="dynamicImport.jsp"></jsp:include>
</body>
</html>
