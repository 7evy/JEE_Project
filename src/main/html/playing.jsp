<!--No servlet-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="forms.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Playing</title>
</head>
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

    <div align="center">
        <%-- Displays the name of the current game. --%>
        <h1> Currently playing : <%=request.getParameter("name")%></h1>

        <%-- Calls PlayingServlet to end the game and send the player back to the list of games. --%>
        <form id="form" action="/playing" method="post">
            <input type="hidden" name="name" value="<%=request.getParameter("name")%>">
            <button>End game</button>
        </form>
    </div>
</body>
</html>