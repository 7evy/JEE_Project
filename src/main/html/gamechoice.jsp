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
    <form action="/gamechoice" method="get">
        <% ArrayList<String> data = (ArrayList<String>) request.getAttribute("data"); %>
        <table border="1px solid black" width="95%">
            <tr border="1px solid black">
                <th width="70%">Game</th>
                <th width="30%">Number of players</th>
            </tr>

            <form id="form0" action="/gamechoice" method="post">
                <input type="hidden" name="game" value="<%=data.get(0)%>">
            </form>

            <% for (int i=0 ; i<data.size() ; i+=2) { %>
                <tr onclick="document.getElementById('form<%=i/2%>').submit()">
                    <form id="form<%=i/2%>" action="/gamechoice" method="post">
                        <input type="hidden" name="game" value="<%=data.get(i)%>">
                    </form>
                    <td> <%= data.get(i) %> </td>
                    <td> <%= data.get(i+1) %> </td>
                </tr>
            <% } %>
        </table>
    </form>
    </div></div>
</body>
</html>