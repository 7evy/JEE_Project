<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<link rel="stylesheet" type="text/css" href="table.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div id="boxdiv" style="width: 65%">
    <br><br><br>
    <h1 align="center">Choose a game</h1>
    <br>
    <div align="center">
    <form action="/gamechoice" method="get">
        <!--   <% String[] games = request.getParameter("data").split(";"); %>
        <table border="1px solid black" width="95%">
            <tr border="1px solid black">
                <th width="50%">Game</th>
                <th width="50%">Number of players</th>
            </tr>
            <tr>
                <td> <% games[0]; %> </td>
            </tr>
        </table>   -->
    </form>
    </div></div>
</body>
</html>