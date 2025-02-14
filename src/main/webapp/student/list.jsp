<%--
  Created by IntelliJ IDEA.
  User: AE
  Date: 5/30/2022
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student </title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>
<%--<a href="/students?act=create">Create</a>--%>
<div class="container">
<div class="row mt-2">
                <div class="col-9">
                    <h2 style="text-align: center">List Student</h2>
                    <table class="table table-striped mt-3">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Age</th>
                            <th scope="col">Class Name</th>
                            <th scope="col">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ds}" var="st">
                            <tr>
                                <td>${st.name}</td>
                                <td>${st.age}</td>
                                <td>${st.clazz.name}</td>
                                <td>
                                    <a class="btn btn-Primary" href="/students?act=view&id=${st.id}">View</a>
                                    <a class="btn btn-secondary" href="/students?act=edit&id=${st.id}">Sửa</a>
                                    <a class="btn btn-secondary" href="/students?act=delete&id=${st.id}">xóa</a>
                                    <a class="btn btn-secondary" href="/students?act=search&name=${st.id}">xóa</a>


<%--                                    <form action="/students" method="post" id="delete${st.id}" style="display: inline">--%>
<%--                                        <input type="hidden" name="act" value="delete">--%>
<%--                                        <input type="hidden" name="id" value="${st.id}">--%>
<%--                                        <a class="btn btn-danger" onclick="xacNhanDelete(${st.id})">Xoá</a>--%>
<%--                                    </form>--%>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
</div>
<%--<c:forEach items="${ds}" var="cl">--%>
<%--    <h1>${cl.id},${cl.name},${cl.age}</h1>--%>
<%--</c:forEach>--%>
</body>
</html>
