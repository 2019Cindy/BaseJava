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
    jsp转义成servlet类的路径:AppData\Local\JetBrains\IntelliJIdea2020.2\tomcat\Unnamed_BaseJava\work\Catalina\localhost\TestServlet\org\apache\jsp
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

<%--
    请求转发：在jso中也可以实现servlet的请求转发功能
        <jsp:forward page="forward.jsp"></jsp:forward>
        注意：标签中不能添加任何字段，除了<jsp:param name="addr" value="wuhan"/>标签外
--%>

<%--
    jsp九大内置对象：
        jsp页面在生成对应的servlet对象的时候，会对应的生成一些对象，在jsp页面中可以直接调用
        注意：内置对象是在jsp页面中使用的，可以在局部代码块、脚本语句中使用，不能在全局代码块中使用（全局代码块在servlet类中，不在service方法里面）
    九大对象：
        pageContext：页面上下文对象，封存当前页面的其他信息，
            注意：每一个页面都有一个对应的pageContext对象，伴随着当前界面的结束而结束
        req
        resp
        session：用于封装同一个用户不同请求的共享数据
        application：相当于servletContext对象，一个web项目只有一个对象，存储着所有用户的共享数据
        page：代表当前的jsp对象
        exception：异常对象，存储当前运行的异常
        config：相当于servletConfig对象，获取web.xml中的配置数据，完成servlet的初始化操作
        out：响应对象，带有缓冲区的响应对象，效率高于resp
    四大作用域：
        pageContext：解决当前页面内的数据共享问题，获取其他内置对象
        req：一次请求的servlet数据共享，通过请求转发的方式，将数据流转到下一个servlet
        session：一次会话，一个用户发送的不同请求之间的数据共享，可以将数据从一个请求流转到其他请求
        application：（servletContext）项目内，不同用户的数据共享问题，将数据从一个用户流转到其他用户
    路径问题：
        获取项目中的资源，可以使用相对路径，也可以使用绝对路径
        相对路径：相对当前jsp页面的路径
            问题：1.资源的路径不能随便更改；2.必须使用../的方式进行文件夹的跳出
        绝对路径：在请求路径前加/，表示当前服务器的根路径，使用时需要添加虚拟项目名称（war包名称）+/ 资源路径

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page session="true" %>
<%@ page errorPage="error.jsp" %>
<%
    String path=request.getContextPath();
    System.out.println(path);
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    System.out.println(basePath);
%>
<html>
<head>
    <base href="<%=basePath%>">
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
<jsp:forward page="forward.jsp">
    <jsp:param name="addr" value="wuhan"/>
</jsp:forward>

<a href="./a/a.jsp">aaa</a>
</body>
</html>
