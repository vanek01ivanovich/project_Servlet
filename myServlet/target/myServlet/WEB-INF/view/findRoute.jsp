<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 22.04.2020
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="icon" href="data:,">
</head>
<body>
    <form method="post">
        <label>
            From:
            <input type="text" name="stationFrom">
        </label>
        <label>
            To:
            <input type="text" name="stationTo">
        </label>
        <label>
            Date:
            <input type="date" name="date">
        </label>
        <button type="submit">Find</button>
    </form>

</body>
</html>
