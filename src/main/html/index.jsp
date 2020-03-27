<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<link rel="stylesheet" type="text/css" href="tab.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connection</title>
</head>
<body>
    <div id="boxdiv" style="width: 40%;">
        <br><br><br>
        <h1 align="center">Welcome</h1>
        <br><br><br>
        <div align="center" class="login">
        <%-- Calls HomeServlet to verify the nickname and password entered.
            The user can connect if they already exist in the database and they are not banned --%>
            <form action="/home" method="post">
                <label>Nickname :</label>
                <input type="text" placeholder="nickname" id="nickname" name="nickname"> <br><br>
                <label>Password :</label>
                <input type="password" placeholder="password" id="password" name="password"><br><br>
                <input type="submit" id="login" value="Submit"><br><br>
            </form>

            <%-- Used if the nickname and password don't match any user, or if a user tries to access pages illegally. --%>
            <% if (request.getAttribute("cred") != null) {
                    if ((int) request.getAttribute("cred") == 1) { %>
                        <p style="color:crimson"><b>Wrong credentials</b></p><br><br><br>
                <% } else if ((int) request.getAttribute("cred") == 2) { %>
                        <p style="color:crimson"><b>Sorry. You have been banned. Acces denied</b></p><br><br><br>
            <% } else {} } else {} %>

            <a href="/register">Create a new account</a>
        </div>
    </div>
</body>
</html>