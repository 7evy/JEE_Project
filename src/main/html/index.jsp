<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<link rel="stylesheet" type="text/css" href="table.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connect</title>
</head>
<body>
    <div id="boxdiv" style="width: 40%;">
    <br><br><br>
    <h1 align="center">Welcome</h1>
    <br><br><br>
    <div align="center" class="login">
        <form action="login" method="post">
            <label>Nickname :</label>
            <input type="text" placeholder="nickname" id="nickname"> <br><br>
            <label>Password :</label>
            <input type="password" placeholder="password" id="password"><br><br>
            <input type="submit" id="login" value="Submit"><br><br>
        </form>
        <a href="register.jsp">Create a new account</a>
    </div></div>
</body>
</html>