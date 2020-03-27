<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<link rel="stylesheet" type="text/css" href="forms.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<a href="/">
<button type="button">
    Back to login
</button>
</a>
<body>
    <div id="boxdiv" style="width: 40%">
        <h1 align="center">
            Register
        </h1><br>
        <div align="center">
            <%-- Calls RegisterServlet to verify each of the inputs (nickname, password, email address, birthday). --%>
            <form action="register" method="post">
                <table>
                    <%-- Input for the nickname --%>
                    <tr>
                        <td align="right"><label>Nickname :</label></td>
                        <td><input type="text" placeholder="nickname" id="nickname" name="nickname"></td>
                    </tr>

                    <%-- Displays the proper message when an input is not valid (used for each input). --%>
                    <% if (request.getAttribute("nickname") != null) { %>
                        <p style="color:crimson"><b>The nickname is already taken</b></p><br><br><br>
                    <% } %>

                    <%-- Inputs for the password (entered twice) --%>
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

                    <% if (request.getAttribute("pswd") != null) { %>
                        <p style="color:crimson"><b>The two passwords given are different</b><br><br><br>
                    <% } %>

                    <%-- Input for the email address --%>
                    <tr></tr><tr></tr><tr></tr>
                    <tr>
                        <td align="right"><label>E-mail :</label></td>
                        <td><input type="text" placeholder="email" id="email" name="email"></td>
                    </tr><tr></tr><tr></tr><tr></tr>

                    <% if (request.getAttribute("email") != null) { %>
                        <p style="color:crimson"><b>Email already used</b><br><br><br>
                    <% } %>

                    <%-- Input for the birthday --%>
                    <tr>
                        <td align="right"><label>Birthday :</label></td>
                        <td><input type="date" placeholder="mm/dd/yyyy" id="birthday" name="birthday"></td>
                    </tr><tr></tr><tr></tr><tr></tr>

                    <% if (request.getAttribute("birth") != null) { %>
                        <p style="color:crimson"><b>You must be over 13 years old to create an account</b><br><br><br>
                    <% } %>

                </table><br>
                <input type="submit" id="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>