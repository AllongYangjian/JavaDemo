<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2020/3/13
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>hello spring mvc</h2>
请求域：<%=request.getAttribute("message")%><br/>
回话域：<%=session.getAttribute("message")%><br/>

</body>
</html>
