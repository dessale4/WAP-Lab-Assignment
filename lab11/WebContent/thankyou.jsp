<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Customer Contact App </title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-info">
        <a class="navbar-brand" href="#">CS472:::Lab11</a>
    </nav>

    <p> <span class = "float-right"><c:out value = "${currDateTime}"></c:out></span></p>
    <div class = "container">
        <div class="list-group">
            <a href="#" class="list-group-item active disabled">
                Thank you! Your message has been recieved as follows:
            </a>
            <a href="#" class="list-group-item list-group-item-action disabled">Name: <c:out value = "${param.fullName}"></c:out> </a>
            <a href="#" class="list-group-item list-group-item-action disabled">Gender: <c:out value = "${param.gender}"></c:out> </a>
            <a href="#" class="list-group-item list-group-item-action disabled">Category: <c:out value = "${param.category}"></c:out> </a>
            <a href="#" class="list-group-item list-group-item-action disabled">Message: <c:out value = "${param.message}"></c:out> </a>
            <a href="ProcessContactFormDataServlet" class="list-group-item list-group-item-action">Please feel free to Contact US again</a>
        </div>
        <footer>Hit count for this page:  <c:out value = "${param.thankYouPageHitCount}"></c:out><span class = "float-right">Total hit count for the entire WebApp: <c:out value = "${totalHitCount}"></c:out></span></footer>
    </div>
</body>
</html>
