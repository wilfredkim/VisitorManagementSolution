<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/30/2017
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CheckOut</title>
</head>
<body>
<form action="checkOut" method="post">
    <table border="1" width="30%" cellpadding="5">
        <thead>
        <tr>
            <th colspan="2">Checking Out</th>
        </tr>
        </thead>
        <tr>
            <td> Enter the IDNumber  of Person who Visited</td>
            <td><input type="number" name="idnum" value="" required/></td>
        </tr>


        <tr>
            <td><input type="submit" value="CHECK-OUT" /></td>
            <td><input type="reset" value="Reset" /></td>
        </tr>

    </table>
</form>
</body>
</html>
