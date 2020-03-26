<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="tab.css" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>

    <% User user = Manager.getCurrentUser();
        if (user == null)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 1)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 2)
            response.sendRedirect("/index.jsp?cred=2"); %>

    <div id="boxdiv">
        <br><br><br>
        <h1 align="center">Player list</h1>
        <br>
        <div align="center">
            <table border="1px solid black">
                <tr border="1px solid black">
                    <th>Nickname</th>
                    <th>Registration date</th>
                    <th>Sessions played</th>
                </tr>
            </table><br><br>
            <button id="ban">Ban</button>
        </div>
    </div>
</body>

</html>