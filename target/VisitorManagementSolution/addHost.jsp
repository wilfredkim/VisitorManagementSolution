<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/1/2017
  Time: 12:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>
<html>
<head>
    <title>Add Host</title>
</head>
<body>
<form method="post" action="addHost">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Register Host</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="" required/></td>
            </tr>

            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value=""required /></td>
            </tr>
            <tr>
                <td> Work Number</td>
                <td><input type="number" name="worknum" value="" required/></td>
            </tr>

            <tr>
                <td> Address</td>
                <td><input type="text" name="address" value="" required/></td>
            </tr>
            <tr>
                <td> PhoneNumber</td>
                <td><input type="text" name="phone" value="" required/></td>
            </tr>
            <tr>
                <td> Gender</td>
                <td>MALE<input type="radio" name="gender"value="MALE"  required>
                    FEMALE<input type="radio" name="gender"value="FEMALE"  required> </td>
            </tr>
            <tr>
                <td> PassWord</td>
                <td>
                    <input type="password" name="pass" required>
                </td>
            </tr>
            <tr>
                <td colspan="2">Already registered!! <a href="hostLogin">Login Here</a></td>
            </tr>
            <tr>
                <td><input type="submit" value="Add" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <%--<tr>
                <td colspan="2">Already registered!! <a href="customerLogin.jsp">Login Here</a></td>
            </tr>--%>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
