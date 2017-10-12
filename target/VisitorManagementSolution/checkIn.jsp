<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/29/2017
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<html>
<head>
    <title>Check-In</title>
</head>
<body>
<form action="checkIn" method="post">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">CheckingIn</th>
        </tr>
        </thead>
        <%--<tr>
            <td>ID Number of Visitor</td>
            <td><input type="number" name="idnum" value="" required/></td>
        </tr>--%>
        <tr>
            <td>Person Visited</td>
            <td><input type="text" name="personV" value="" required/></td>
        </tr>
        <tr >
            <td>Purpose For Visit</td>
            <td><textarea name="purpose" id="" cols="10" rows="5"></textarea></td>
        </tr>

        <tr>
            <td><input type="submit" value="CHECK-IN" /></td>
            <td><input type="reset" value="Reset" /></td>
        </tr>

    </table>
</form>
</body>
</html>
