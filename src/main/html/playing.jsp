<!--No servlet-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<link rel="stylesheet" type="text/css" href="form.css" />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Playing</title>
</head>
<body>
<h1> Currently playing : <% out.println(request.getParameter("name")); %></h1>
</body>
</html>