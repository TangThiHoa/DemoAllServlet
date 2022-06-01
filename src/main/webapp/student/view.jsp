<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Student</h1>
<p>
    <a href="/students">Back to student list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["st"].getName()}</td>
    </tr>
    <tr>
        <td>Age: </td>
        <td>${requestScope["st"].getAge()}</td>
    </tr>
    <tr>
        <td>ClassId: </td>
        <td>${requestScope["st"].getClazz().getId()}</td>
    </tr>
</table>
</body>
</html>