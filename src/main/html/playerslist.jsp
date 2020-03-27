<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="launch.Manager" %>
<%@ page import="user.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
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
        if (user == null)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 1)
            response.sendRedirect("/index.jsp?cred=1");
        else if (user.getStatus() == 2)
            response.sendRedirect("/index.jsp?cred=2"); %>

    <div id="boxdiv">
        <br><br><br>
        <h1 align="center">Player list</h1>
        <br>
        <div align="center">
                    <form action="/playerslist" method="get">
        <% String data = request.getParameter("data");
           List<String> playersAndAtributes = Arrays.asList(data.split(";"));
           List<String> showAtributes;
           String attributes = ""; %>
        <table border="1px solid black">
                <tr border="1px solid black">
                    <th>Nickname</th>
                    <th>Registration date</th>
                    <th>Sessions played</th>
               </tr>
            <% for (int i=0 ; i<playersAndAtributes.size() ; i++) {
                attributes = playersAndAtributes.get(i);
           showAtributes = Arrays.asList(attributes.split("!")); 
                 %>
                <tr id="clickable" onclick="document.location='/playerdetails.jsp?data=<%=showAtributes.get(0)%>'">
                    <td> <%= showAtributes.get(0) %> </td>
                    <td> <%= showAtributes.get(1) %> </td>
                    <td> <%= showAtributes.get(2) %> </td>
                </tr>
            <% } %>
            </table><br><br>
    </form>
            <button id="ban">Ban</button>
        </div>
    </div>

</body>

</html>