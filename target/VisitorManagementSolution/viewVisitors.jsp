<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 10/2/2017
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="receptionistPage.jsp"%>
<html>
<head>
    <title>Visitors</title>
</head>
<body>
<TABLE BORDER="3" width="100%" class="table">
    <tr>
        <th width="16%">Name</th>
        <th width="16%">ID Number</th>
        <th width="16%">Gender</th>
        <th width="16%">Category</th>
        <th width="16%">Phone Number</th>
        <th width="16%">Status</th>

    </tr>
    <c:forEach var="visitors" items="${visitorslist}">
        <tr>
        <td width="16%"><c:out value="${visitors.name}"></c:out></td>
        <td width="16%"><c:out value="${visitors.idNumber}"></c:out></td>
        <td width="16%"><c:out value="${visitors.gender}"></c:out></td>
        <td width="16%"><c:out value="${visitors.visitorCategory}"></c:out></td>
        <td width="16%"><c:out value="${visitors.phoneNumber}"></c:out></td>
        <td width="16%"><c:out value="${visitors.status}"></c:out></td>
        </tr>
    </c:forEach>
</TABLE>
</body>
</html>
