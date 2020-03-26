<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<html lang="en">
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="tab.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<a href="/">
<button type="button">
    Disconnect
</button>
</a>
<body>

    <% User user = Manager.getCurrentUser();
        if (user == null)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 2)
            response.sendRedirect("/index.jsp?cred=2"); %>

    <div id="boxdiv" style="width: 65%">
    <br><br><br>
    <h1 align="center">Choose a game</h1>
    <br>
    <div align="center">
    <form action="/gamechoice" method="get">
        <% String data = request.getParameter("data");
           List<String> games = Arrays.asList(data.split(";")); %>
        <table border="1px solid black" width="95%">
            <tr border="1px solid black">
                <th width="70%">Game</th>
                <th width="30%">Number of players</th>
            </tr>
            <% for (int i=0 ; i<games.size() ; i+=2) { %>
                <tr id="clickable" onclick="document.getElementById('form<%=i/2%>').submit()">
                    <form id="form<%=i/2%>" action="/gamechoice" method="post">
                        <input type="hidden" name="game" value="<%=games.get(i)%>">
                    </form>
                    <td> <%= games.get(i) %> </td>
                    <td> <%= games.get(i+1) %> </td>
                </tr>
            <% } %>
        </table>
    </form>
    </div></div>
</body>
</html>