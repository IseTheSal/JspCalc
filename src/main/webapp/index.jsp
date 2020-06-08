<html>
<body>
<h3>Hello ${sessionScope.currentUser.name}!</h3>
<ul>

    <li><a href="/reg">Reg</a></li>
    <li><a href="/auth">Auth</a></li>
    <li><a href="/calc">Calc</a></li>
    <li><a href="/logout">Logout</a></li>
    <li><a href="/history">History</a></li>
    <li><a href="/ahistory">Whole History</a></li>
    <li><a href="/users">Users</a></li>

</ul>
${requestScope.message}
</body>
</html>
