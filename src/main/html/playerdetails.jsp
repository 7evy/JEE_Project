<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="form.css" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
</head>

<body>

    <% User user = Manager.getCurrentUser();
        if (user == null)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 1)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 2)
            response.sendRedirect("/index.jsp?cred=2"); %>

    <div id="boxdiv" style="width:40%">
        <h1 align="center">
            Nom du jeu
        </h1><br>
        <div align="center">
            <form action="player" method="get">
                <% String data = request.getParameter("data"); %>
                <% List<String> details = Arrays.asList(data.split(";")); %>
                <table>
                    <tr>
                        <td> Nickname : </td><td> <%= details.get(0) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Email address : </td><td> <%= details.get(1) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Currently playing : </td><td> <%= details.get(2) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Registration date : </td><td> <%= details.get(3) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Birthday : </td><td> <%= details.get(4) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                </table>
            </form>
        </div>
    </div>
</body>

</html>