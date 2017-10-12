<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/30/2017
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Receptionist Page</title>
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

             <li><a href="searchVisitor">Check-In</a></li>
            <li><a href="receptionistChat">Send Notification</a></li>
            <li><a href="checkOut">CheckOut Visitor</a></li>
               <li><a href="viewVisitor">View Visitors</a></li>
            <li><a href="receptionistLogout">Logout</a></li>

            <li><a href="#">About Us</a></li>
        </ul>
    </div>
</nav>
</body>
</html>
