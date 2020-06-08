<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>History</title>
</head>
<body>
<ul>
<%
    List<String> history = (List) request.getSession().getAttribute("history");
    for (int i = 0; i < history.size(); i++) {
        out.println("<li>" + history.get(i) + "</li>");
    }
%>
</ul>


<a href="/">Back</a>

</body>
</html>
