<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="tab.css"/>
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

    <div id="boxdiv" style="width: 80%;">
    <br><br><br>
    <h1 align="center">Finished games</h1>
    <br>
    <div align="center">
        <table>
            <tr>
                <th>Game</th>
                <th>Nickname</th>
                <th>Started on</th>
                <th>Started at</th>
                <th>Ended on</th>
                <th>Ended at</th>
                <th>Playing time</th>
            </tr>
        </table>
    </div></div>
</body>
</html>