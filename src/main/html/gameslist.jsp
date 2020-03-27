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
    </a>
    <a href="/playerslist">
    <button type="button" style="float: right;">
        Players
    </button>
    </a>
    <a href="/onsessions">
    <button type="button" style="float: right;">
        Sessions
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

    <div id="boxdiv" style="width: 35%; text-align: center;">
        <br><br><br>
        <h1 align="center">Game list</h1>
        <br>

        <%-- Calls GamesListServlet to fill an HTML table with all the available games. --%>
        <form action="/gameslist" method="post">
            <%-- Buttons used to add games, and delete one or more games at a time. --%>
            <button id="addelete" name="addelete" value="add">Add</button>
            <button id="addelete" name="addelete" value="delete">Delete</button>
            <br><br>
            <div align="center">

                <%-- data contains the names and numbers of players of every game in the database. --%>
                <% ArrayList<String> data = (ArrayList<String>) request.getAttribute("data"); %>

                <table border="1px solid black">
                    <tr border="1px solid black">
                        <th width="50%">Game</th>
                        <th width="50%">Number of players</th>
                    </tr>
                    <%-- Special row to add a new game to the database. --%>
                    <tr>
                        <th width="50%"><input type="text" name="newgame"></th>
                        <th width="50%"></th>
                        <th></th>
                    </tr>

                    <%-- Fills the table with data --%>
                    <% for (int i=0 ; i<data.size() ; i+=2){ %>
                    <tr>
                        <td> <%= data.get(i) %> </td>
                        <td> <%= data.get(i+1) %> </td>
                        <%-- Checkboxes allow to delete several games at the same time. --%>
                        <td> <input type="checkbox" name="checkbox" value="<%=i/2%>"> </td>
                    </tr>
                    <% } %>

                </table>
            </div>
        </form>
    </div>
</body>

</html>