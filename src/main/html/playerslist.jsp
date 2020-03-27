<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<%@ page import="java.util.ArrayList" %>
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
    <a href="/gameslist">
    <button type="button" style="float: right;">
        Games
    </button>
    </a>
    <a href="/onsessions">
    <button type="button" style="float: right;">
        Sessions
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

    <div id="boxdiv">
        <br><br><br>
        <h1 align="center">Player list</h1>
        <br>
        <div align="center">
        <form action="/playerslist" method="get">
        <% ArrayList<ArrayList<Object>> data = (ArrayList<ArrayList<Object>>) request.getAttribute("data"); %>
        <table border="1px solid black">
                <tr border="1px solid black">
                    <th>Nickname</th>
                    <th>Registration date</th>
                    <th>Sessions played</th>
               </tr>

            <form id="form0" action="/playerslist" method="post">
                <input type="hidden" name="pseudo" value="<%=data.get(0).get(0)%>">
            </form>

            <% for (int i=0 ; i<data.size() ; i++) { %>
                <tr onclick="document.getElementById('form<%=i%>').submit()">
                    <form id="form<%=i%>" action="/playerslist" method="post">
                        <input type="hidden" name="pseudo" value="<%=data.get(i).get(0)%>">
                    </form>
                    <td> <%= data.get(i).get(0) %> </td>
                    <td> <%= data.get(i).get(1) %> </td>
                    <td> <%= data.get(i).get(2) %> </td>
                </tr>
            <% } %>
            </table><br><br>
        </form>
        <button id="ban">Ban</button>
        </div>
    </div>

</body>

</html>