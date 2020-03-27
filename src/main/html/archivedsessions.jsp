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
<div>
    <%-- Buttons to allow admins to navigate between pages. --%>
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

    <%-- The code below prevents any unauthorized user to access the page :
         banned, non-admin or non-logged in users are sent back to the Connection page. --%>
    <% User user = Manager.getCurrentUser();
        if (user == null || user.getStatus() > 0)
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("cred", 1);
            rd.forward(request, response);
        } %>

    <div id="boxdiv" style="width: 90%">
        <br><br><br>
        <h1 align="center">Finished sessions</h1>
        <br>
        <div align="center">
            
            <%-- Calls ArchivedSessionsServlet to fill an HTML table with all the finished sessions. --%>
            <form action="/offsessions" method="get">
                <br><br>
                <div align="center">

                    <%-- data contains the game, player's nickname, start and finish date/time of every archived session. --%>
                    <% ArrayList<String> data = (ArrayList<String>) request.getAttribute("data"); %>

                    <table border="1px solid black">
                        <tr border="1px solid black">
                            <th width="20%">Game</th>
                            <th width="20%">Player</th>
                            <th width="20%">Started at</th>
                            <th width="20%">Ended at</th>
                            <th width="20%">Duration</th>
                        </tr>

                        <%-- Fills the table with data. --%>
                        <% for (int i=0 ; i<data.size() ; i+=5){ %>
                        <tr>
                            <td> <%= data.get(i) %> </td>
                            <td> <%= data.get(i+1) %> </td>
                            <td> <%= data.get(i+2) %> </td>
                            <td> <%= data.get(i+3) %> </td>
                            <td> <%= data.get(i+4) %> </td>
                        </tr>
                        <% } %>

                    </table>
                </div>
            </form>
        </div>
    </div>
</body>
</html>