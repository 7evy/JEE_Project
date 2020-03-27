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
    <%-- Buttons to allow admins to navigate between pages. --%>
    <a href="/">
    <button type="button">
        Disconnect
    </button>
    <a href="/offsessions">
    <button type="button" style="float: right;">
        Archived
    </button>
    </a>
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

    <%-- The code below prevents any unauthorized user to access the page :
         banned, non-admin or non-logged in users are sent back to the Connection page. --%>
    <% User user = Manager.getCurrentUser();
        if (user == null || user.getStatus() > 0)
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("cred", 1);
            rd.forward(request, response);
        } %>

    <%-- This page is refreshed every two minutes. --%>
    <% response.setIntHeader("Refresh", 120); %>

    <div id="boxdiv" style="width: 70%">
        <br><br><br>
        <h1 align="center">Session list</h1>
        <br>

        <%-- Manually refreshes the page. --%>
        <form action="/onsessions" method="get">
            <button>Refresh</button>
        </form>

        <%-- Calls ActiveSessionsServlet to fill an HTML table with all the sessions in progress. --%>
        <form action="/onsessions" method="post">
            <%-- Closes a session (kicks the player out) or several at a time. --%>
            <button>Close Session</button>
            <br><br>
            <div align="center">

                <%-- data contains the game, player's nickname, and start date/time of every active session. --%>
                <% ArrayList<String> data = (ArrayList<String>) request.getAttribute("data"); %>

                <table border="1px solid black">
                    <tr border="1px solid black">
                        <th width="30%">Game</th>
                        <th width="30%">Player</th>
                        <th width="40%">Started at</th>
                    </tr>

                    <%-- Fills the table with data. --%>
                    <% for (int i=0 ; i<data.size() ; i+=3){ %>
                    <tr>
                        <td> <%= data.get(i) %> </td>
                        <td> <%= data.get(i+1) %> </td>
                        <td> <%= data.get(i+2) %> </td>
                        <%-- Checkboxes allow the admin to close several sessions at once. --%>
                        <td> <input type="checkbox" name="checkbox" value="1"> </td>
                    </tr>
                    <% } %>

                </table>
            </div>
        </form>
    </div>
</body>
</html>
