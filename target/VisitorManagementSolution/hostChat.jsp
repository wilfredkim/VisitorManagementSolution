<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/30/2017
  Time: 1:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Host Page</title>
    <script type="text/javascript">
        var socket;

        function connect() {
            socket = new WebSocket("ws://localhost:8081/VisitorManagementSolution/chat/" +document.getElementById("sender").value);
            socket.onmessage = onMessage;
        }

        socket.onClose = function (event) {
            onClose(event)

        };
        socket.onError = function (event) {
            onError(event)
        };

        function onMessage(event) {
            alert(event.data);
        }

        function sendMessage() {

            socket.send(JSON.stringify({
                "recepient": document.getElementById("recepient").value,
                "content": document.getElementById("message").value,
                "sender": document.getElementById("sender").value
            }));
        }

        function onClose(event) {
            alert(event.data)

        }

        function onError(event) {
            alert(event.data)

        }


        connect();
    </script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Visitor Management Solution</a>
        </div>
        <ul class="nav navbar-nav">

            <li class="active"><a href="index.jsp">Home</a></li>
            <%-- <li><a href="addvisitor">Visitor</a></li>--%>
            <%-- <li><a href="hostChat.jsp">Inbox </a></li>--%>
            <li><a href="hostLogout">Logout</a></li>

            <li><a href="#">About Us</a></li>
        </ul>
    </div>
</nav>

Enter You Email: <input type="text" id="sender">
<input type="button" value="Connect" onclick="connect()"><br>
<br/>
Enter Recepient:<input type="text" id="recepient"/>
<br/>
Enter Message:<textarea name="" id="message" cols="30" rows="10"></textarea><br/>
<input type="button" value="SendMsg" onclick="sendMessage()"/>


</body>
</html>
