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

    <% User user = Manager.getCurrentUser();
        if (user == null)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 2)
            response.sendRedirect("/index.jsp?cred=2"); %>

    <div align="center">
    <h1> Currently playing : <%=request.getParameter("name")%></h1>
    <form id="form" action="/playing" method="post">
        <input type="hidden" name="name" value="<%=request.getParameter("name")%>">
        <button>End game</button>
    </form>
    </div>
    </body>
</html>