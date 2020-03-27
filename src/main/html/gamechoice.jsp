<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
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

    <%-- The code below prevents any unauthorized user to access the page :
         banned or non-logged in users are sent back to the Connection page. --%>
    <% User user = Manager.getCurrentUser();
        if (user == null || user.getStatus() > 1)
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("cred", 1);
            rd.forward(request, response);
        } %>

    <div id="boxdiv" style="width: 65%">
        <br><br><br>
        <h1 align="center">Choose a game</h1>
        <br>
        <div align="center">
            <%-- Calls GameChoiceServlet to fill an HTML table with the available games. --%>
            <form action="/gamechoice" method="get">

                <%-- data contains the names and numbers of players of every game in the database.
                     Favorite games are displayed first. --%>
                <% ArrayList<String> data = (ArrayList<String>) request.getAttribute("data"); %>
                
                <table border="1px solid black" width="95%">
                    <tr border="1px solid black">
                        <th width="70%">Game</th>
                        <th width="30%">Number of players</th>
                    </tr>

                    <form id="form0" action="/gamechoice" method="post">
                        <input type="hidden" name="game" value="<%=data.get(0)%>">
                    </form>

                    <%-- Fills the table with data. --%>
                    <% for (int i=0 ; i<data.size() ; i+=2) { %>
                        <%-- The rows of the table are links to the corresponding game. --%>
                        <tr onclick="document.getElementById('form<%=i/2%>').submit()">
                            <%-- One form per game is used to interact with the servlet and redirect the user. --%>
                            <form id="form<%=i/2%>" action="/gamechoice" method="post">
                                <input type="hidden" name="game" value="<%=data.get(i)%>">
                            </form>
                            <td> <%= data.get(i) %> </td>
                            <td> <%= data.get(i+1) %> </td>
                        </tr>
                    <% } %>

                </table>
            </form>
        </div>
    </div>
</body>
</html>