<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=java.util.List %>
<%@ page import=java.util.Arrays %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="form.css" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
</head>

<body>
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
                        <td> Nickname : </td><td> <%= details.get(0); %>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Email address : </td><td> <%= details.get(1); %>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Currently playing : </td><td> <%= details.get(2); %>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Registration date : </td><td> <%= details.get(3); %>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Birthday : </td><td> <%= details.get(4); %>
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