<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="tab.css" />

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <div id="boxdiv" style="width: 35%; text-align: center;">
        <br><br><br>
        <h1 align="center">Game list</h1>
        <br>
        <button id="addelete" name="addelete" value="add">Add</button>
        <button id="addelete" name="addelete" value="delete">Delete</button>
        <br><br>
        <div align="center">
            <form action="/gameslist" method="get"></form>
                <% String data = request.getParameter("data");
            List<String> games = Arrays.asList(data.split(";"));%>
                <table border="1px solid black">
                    <tr border="1px solid black">
                        <th width="50%">Game</th>
                        <th width="50%">Number of players</th>
                    </tr>
                    <% for (int i=0 ; i<games.size() ; i+=2){ %>
                    <tr>
                        <td> <% out.println(games.get(i)); %> </td>
                        <td> <% out.println(games.get(i+1)); %> </td>
                        <td> <input type="checkbox" name="checkbox" value=<% out.println(i); %>> </td>
                    </tr>
                    <% } %>
                </table>
            </form>
        </div>
    </div>
</body>

</html>