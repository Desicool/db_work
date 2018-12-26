<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/25
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息</title>
    <link rel="stylesheet" type="text/css" href="/css/InfoStyle.css">
</head>
<body>
    <form action="${pageContext.request.contextPath}/searchEmployee.p" method="post">
        <input type="text" name="searchStr">    <input type="submit" value="Submit"><br>
        <input type="radio" name="searchType" value="name">按姓名
        <input type="radio" name="searchType" value="station">按站点
    </form>
    <fieldset class="childFrame">
        <legend>
            结果
        </legend>
        ${ret}
    </fieldset>
</body>
</html>
