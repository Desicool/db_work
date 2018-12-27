<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/27
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StationInfo</title>
    <link rel="stylesheet" type="text/css" href="/css/InfoStyle.css">
</head>
<body>
    <form action="searchStation" method="post">
        <input type="text" class="str_input" name="searchStr">    <input class="submit_button" type="submit"><br>
        <input type="radio" name="searchType" value="name" class="radio_button">按名称
        <input type="radio" name="searchType" value="station" class="radio_button">按地址
    </form>


    <fieldset class="childFrame">
        <legend>
            站点列表
        </legend>
        ${ret}
    </fieldset>
</body>
</html>
