<%--
  Created by IntelliJ IDEA.
  User: AE
  Date: 5/30/2022
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List Class

<c:forEach items="${ds}" var="cl">
    <h1>${cl.id} ,${cl.name}</h1>
</c:forEach>

</body>
</html>
