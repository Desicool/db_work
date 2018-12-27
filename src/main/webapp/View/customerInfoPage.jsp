<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/26
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/InfoStyle.css">
</head>
<body>

<form action="/findCustomer.post" method="post">
    <input type="text" name="customerName" class="str_input" placeholder="请输入姓名">
    <input type="submit" class="submit_button" value="搜索" id="searchEmployee">
</form>
    <fieldset class="childFrame">
        <legend>结果</legend>
        ${result}
    </fieldset>
</body>
</html>
