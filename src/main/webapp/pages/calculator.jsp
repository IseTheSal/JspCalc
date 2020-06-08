
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form action="/calc" method="post">
    <input type="text" name="num1" placeholder="Number 1">
    <select name="operation">
        <option value="plus">+</option>
        <option value="minus">-</option>
        <option value="divided">/</option>
        <option value="power">*</option>
    </select>
    <input type="text" name="num2" placeholder="Number 2">
    <button>Calc</button>
</form>

${requestScope.answer}

<a href="/">Back</a>
</body>
</html>
