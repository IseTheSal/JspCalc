<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h3>Hello ${sessionScope.currentUser.name}!</h3>
<ul>

        <li><a href="/reg">Reg</a></li>
        <li><a href="/auth">Auth</a></li>
        <li><a href="/ahistory">Whole History</a></li>

    <c:if test="${sessionScope.isAuth}">

        <li><a href="/calc">Calc</a></li>
        <li><a href="/logout">Logout</a></li>
        <li><a href="/history">History</a></li>
        <li><a href="/users">Users</a></li>
    </c:if>
</ul>
${requestScope.message}
</body>
</html>
