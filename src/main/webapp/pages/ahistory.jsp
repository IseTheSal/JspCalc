<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Whole History</title>
</head>
<body>
<ul>
    <c:forEach items="${applicationScope.ahistory}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<a href="/">Back</a>
</body>
</html>
