
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>
<p>
    <a href="/students">Back to student list</a>
</p>
<div class="container">
    <div class="row mt-2">
        <div class="col-9">
            <h2 style="text-align: center">List Student</h2>
            <table class="table table-striped mt-3">
                <tbody>
                <form method="post">
                    <input type="text" name="name" placeholder="enter in name"> <br>
                    <br>
                    <input type="text" name="age"placeholder="enter in age"> <br>
                    <br>
                    <select name="classId">
                        <c:forEach items="${ds}" var="cl">
                            <option value="${cl.id}">${cl.name} </option>
                        </c:forEach>
                    </select><br>
                    <br>
                    <button>Click</button>
                </form>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%--<c:forEach items="${ds}" var="cl">--%>
<%--    <h1>${cl.id},${cl.name},${cl.age}</h1>--%>
<%--</c:forEach>--%>
</body>
</html>
