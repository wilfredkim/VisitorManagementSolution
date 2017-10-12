<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/30/2017
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="receptionistPage.jsp" %>
<html>
<head>
    <title>Send Message </title>
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
Enter You Email: <input type="text" id="sender">
<input type="button" value="Connect" onclick="connect()"><br>
<br/>
Enter Recepient Email:<input type="text" id="recepient"/>
<br/>
Enter Message:<textarea name="" id="message" cols="30" rows="10"></textarea><br/>
<input type="button" value="Send Message" onclick="sendMessage()"/>


</body>
</html>
