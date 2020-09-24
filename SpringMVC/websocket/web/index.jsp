<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 2020/4/16
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <script>
    var webSocket = new WebSocket('ws://'+window.location.host+'/websocket_war_exploded/websocket');
   webSocket.onopen = function (ev) {
      webSocket.send('sb');
   };
   webSocket.onmessage = function (ev) {
    console.log(ev.data);
   };
  </script>
  </body>
</html>
