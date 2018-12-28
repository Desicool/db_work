<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2018/12/25
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link>
    <link rel="stylesheet" type="text/css" href="/css/mainPage.css">
    <title>Mainpage</title>

</head>
<body>
    <div id = "menu">
        ${leftMenu}
    </div>
    <div id="childPageDiv">
        <iframe name="MainView" id="MainView"></iframe>
    </div>
</body>
</html>
