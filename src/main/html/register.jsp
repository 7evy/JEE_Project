<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<link rel="stylesheet" type="text/css" href="form.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<a href="/">
<button class="favorite styled"
        type="button">
    back to login
</button>
</a>
<body>
    <div id="boxdiv" style="width: 40%">
    <h1 align="center">
        Register
    </h1><br>
    <div align="center">
        <form action="register" method="post">
            <table>
                <tr>
                    <td align="right"><label>Nickname :</label></td>
                    <td><input type="text" placeholder="nickname" id="nickname" name="nickname"></td>
                </tr>
                <%
                    if (request.getParameter("nickname") == null) {
                        //default page
                    } else if (request.getParameter("nickname").equals("1")) { %>
                        The nickname is already taken<br><br><br>
                    <% }
                %>
                <tr></tr><tr></tr><tr></tr>
                <tr>
                    <td align="right"><label>Password :</label></td>
                    <td><input type="password" placeholder="password" id="password" name="password1"></td>
                </tr>
                <tr></tr><tr></tr><tr></tr>
                <tr>
                    <td align="right"><label>Confirm password :</label></td>
                    <td><input type="password" placeholder="password" id="confirm" name = "password2"></td>
                </tr>
                <%
                    if (request.getParameter("pswd") == null) {
                        //default page
                    } else if (request.getParameter("pswd").equals("1")) { %>
                        The 2 passwords given are different.<br><br><br>
                    <% }
                %>
                <tr></tr><tr></tr><tr></tr>
                <tr>
                    <td align="right"><label>E-mail :</label></td>
                    <td><input type="text" placeholder="email" id="email" name="email"></td>
                </tr><tr></tr><tr></tr><tr></tr>
                <%
                    if (request.getParameter("email") == null) {
                        //default page
                    } else if (request.getParameter("email").equals("1")) { %>
                        Email already used.<br><br><br>
                    <% }
                %>
                <tr>
                    <td align="right"><label>Birthday :</label></td>
                    <td><input type="date" placeholder="mm/dd/yyyy" id="birthday" name="birthday"></td>
                </tr><tr></tr><tr></tr><tr></tr>
                <%
                    if (request.getParameter("birth") == null) {
                        //default page
                    } else if (request.getParameter("birth").equals("1")) { %>
                        There is a pb with the date. You must be over 13 to register.<br><br><br>
                    <% }
                %>
            </table><br>
            <input type="submit" id="submit" value="Submit">
        </form>
    </div></div>
</body>
</html>