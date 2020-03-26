<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<html lang="en">
<link rel="stylesheet" type="text/css" href="table.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script language="Javascript">
        var elements = document.getElementsByClassName("clickable");
        for (var i = 0; i < elements.length; i++) {
            var element = elements[i];
            element.addEventListener("click", function() {
                var href = this.dataset.href;
                if (href) {
                    window.location.assign(href);
                } }); } 
    </script>
</head>
<body onload="onload">
    <div id="boxdiv" style="width: 65%">
    <br><br><br>
    <h1 align="center">Choose a game</h1>
    <br>
    <div align="center">
    <form action="/gamechoice" method="get">
        <% String data = request.getParameter("data");
           List<String> games = Arrays.asList(data.split(";")); %>
        <table border="1px solid black" width="95%">
            <tr border="1px solid black">
                <th width="50%">Game</th>
                <th width="50%">Number of players</th>
            </tr>
            <% for (int i=0 ; i<games.size() ; i+=2) { %>
                <tr class="clickable" href="/playing.jsp?name=<% out.print(games.get(i)); %>">
                    <td> <% out.println(games.get(i)); %> </td>
                    <td> <% out.println(games.get(i+1)); %> </td>
                </tr>
            <% } %>
        </table>
    </form>
    </div></div>
</body>
</html>