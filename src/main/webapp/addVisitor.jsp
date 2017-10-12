<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 9/29/2017
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="receptionistPage.jsp"%>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
<form method="post" action="addvisitor">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Register Visitor</th>
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
                <td> ID Number</td>
                <td><input type="number" name="idnum" value="" required/></td>
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
                <td> Visitor Category</td>
                <td>
                <select name="category" id="" required>

                    <option>VIP</option>
                    <option>NORMAL</option>
                </select>
                </td>
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
