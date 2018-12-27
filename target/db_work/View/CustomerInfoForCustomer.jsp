<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/27
  Time: 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CustomerInfoForCustomer</title>

    <link rel="stylesheet" type="text/css" href="/css/InfoStyle.css">
</head>
<body>
    <fieldset class="detail_info">
        <legend>
            所有订单
        </legend>
        ${order}
    </fieldset>
    <fieldset class="detail_info">
        <legend>常用收件地址</legend>
        ${receiveAddress}
    </fieldset>
    <fieldset class="detail_info">
        <legend>常用寄件地址</legend>
        ${sendAddress}
    </fieldset>
</body>
</html>
