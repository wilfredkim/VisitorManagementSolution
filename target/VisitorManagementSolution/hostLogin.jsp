<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/30/2017
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<html>
<head>
    <title>Host Login</title>

    <script type="text/javascript">
        var socket;

        function connect() {
            socket = new WebSocket("ws://localhost:8081/VisitorManagementSolution/chat/" +document.getElementById("email").value);
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
                //"sender": document.getElementById("sender").value
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
<form  action="hostLogin" method="post">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Sign-In</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                <td>Email</td>
                <td><input type="text" name="email" id="email"  required/></td>
            </tr>

            <tr>
                <td>PassWord</td>
                <td><input type="password" name="pass" value=""required /></td>
            </tr>

            <td><input type="submit" value="Sign-In" onclick="connect()"/></td>
            <td><input type="reset" value="Reset" /></td>
            </tr>

            </tbody>
        </table>
    </center>
</form>
</body>
</html>
