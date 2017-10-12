<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/2/2017
  Time: 8:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="receptionistPage.jsp"%>
<html>
<head>
    <title>Search</title>
</head>
<body>
<form action="searchVisitor" method="post">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">Search Visitor</th>
        </tr>
        </thead>
        <tr>
            <td>ID Number of Visitor</td>
            <td><input type="number" name="idnum" value="" required/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Search" /></td>
            <td><input type="reset" value="Reset" /></td>
        </tr>


    </table>
</form>
</body>
</html>
