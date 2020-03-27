<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="tab.css" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<div>
    <a href="/">
    <button type="button">
        Disconnect
    </button>
    </a>
    <a href="/playerslist">
    <button type="button" style="float: right;">
        Players
    </button>
    </a>
    <a href="/gameslist">
    <button type="button" style="float: right;">
        Games
    </button>
    </a>
</div>
<body>

    <% User user = Manager.getCurrentUser();
        if (user == null || user.getStatus() > 0)
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("cred", 1);
            rd.forward(request, response);
        } %>

    <% response.setIntHeader("Refresh", 30); %>
    <div id="boxdiv" style="width: 70%; text-align: center;">
        <br><br><br>
        <h1 align="center">Session list</h1>
        <br>
        <form action="/onsessions" method="get">
            <button>Refresh</button>
        </form>
        <form action="/onsessions" method="post">
            <button>Close Session</button>
            <br><br>
            <div align="center">
                <% ArrayList<String> data = (ArrayList<String>) request.getAttribute("data"); %>
                <table border="1px solid black">
                    <tr border="1px solid black">
                        <th width="30%">Game</th>
                        <th width="30%">Player</th>
                        <th width="40%">Started at</th>
                    </tr>
                    <% for (int i=0 ; i<data.size() ; i+=3){ %>
                    <tr>
                        <td> <%= data.get(i) %> </td>
                        <td> <%= data.get(i+1) %> </td>
                        <td> <%= data.get(i+2) %> </td>
                        <td> <input type="checkbox" name="checkbox<%=i/3%>" value="1"> </td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </form>
    </div>
</body>

</html>