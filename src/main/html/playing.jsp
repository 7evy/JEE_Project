<!--No servlet-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="form.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Playing</title>
</head>
<body onload="document.getElementByID('form1').submit()">

    <% User user = Manager.getCurrentUser();
        if (user == null)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 2)
            response.sendRedirect("/index.jsp?cred=2"); %>

    <form id="form1" action="/playing" method="post">
        <input type="hidden" name="name" value="<%=request.getParameter("name")%>">
        <input type="hidden" name="start" value="1">
        <input type="hidden" name="end" value="0">
    </form>
    <h1 text-align="center"> Currently playing : <%=request.getParameter("name")%></h1>

    <form id="form2" action="/playing" method="post">
        <input type="hidden" name="name" value="<%=request.getParameter("name")%>">
        <input type="hidden" name="start" value="0">
        <input type="hidden" name="end" value="1">
    </form>
    <button onclick="document.getElementById('form2').submit()">End game</button>

    </body>
</html>