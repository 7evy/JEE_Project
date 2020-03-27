<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="forms.css" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>
</head>

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

    <div id="boxdiv" style="width:40%">
        <h1 align="center">
            Player info
        </h1><br>
        <div align="center">

            <%-- Calls PlayerServlet to obtain the nickname, email address, birthday, registration date and current game of the player. --%>
            <form action="player" method="get">

                <%-- data contains the information listed above. --%>
                <% ArrayList<String> data = request.getAttribute("data"); %>

                <table>
                    <tr>
                        <td> Nickname : </td><td> <%= data.get(0) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Email address : </td><td> <%= data.get(1) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Currently playing : </td><td> <%= data.get(2) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Registration date : </td><td> <%= data.get(3) %></td>
                    </tr>
                    <tr></tr>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <td> Birthday : </td><td> <%= data.get(4) %></td>
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