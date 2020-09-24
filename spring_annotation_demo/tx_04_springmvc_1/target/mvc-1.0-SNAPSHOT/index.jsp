<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2020/3/13
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/hello">SpringMVC基于servlet3.0规范纯注解开发入门</a>
<hr/>
<a href="${pageContext.request.contextPath}/userRequestMapping">userRequestMapping Get</a>
<hr/>
<form action="${pageContext.request.contextPath}/userRequestMapping" method="post">
    <input type="submit" value="userRequestMapping post">
</form>
<hr/>
<a href="${pageContext.request.contextPath}/userRequestHeader">userRequestHeader</a>
<hr/>
<a href="${pageContext.request.contextPath}/userCookieValue">userCookieValue</a>
<hr/>
<a href="${pageContext.request.contextPath}/userModelAttribute?name=sb">userModelAttribute</a>
<hr/>
<a href="${pageContext.request.contextPath}/userModelAttribute2?name=yangjian">userModelAttribute</a>
<hr/>
@SessionAttribute和@SessionAttributes注解的使用<br/>
<a href="${pageContext.request.contextPath}/userSessionAttributes?name=yangjian">userSessionAttributes</a><br>
<a href="${pageContext.request.contextPath}/userSessionAttribute?name=yangjian">userSessionAttribute</a>
<hr/>
@ExceptionHandler注解的使用<br/>
<a href="${pageContext.request.contextPath}/userExceptionHandler?age=-1">ExceptionHandler注解的使用</a><br>
</body>
</html>
