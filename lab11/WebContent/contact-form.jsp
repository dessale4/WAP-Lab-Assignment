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
        <a class="navbar-brand" href="#">CS472-WAP:::Lab11</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">About <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="contact-form.jsp">Contact Us <span class="sr-only">(current)</span></a>
            </li>
            
            </ul>
            <ul class="navbar-nav mr-auto float-right">
                <li class="nav-item">
                    <a class="nav-link active" href="#">Welcome</a>
                </li>
                
                <li class="nav-item">
                    <button type="button" class="btn btn-primary">Sign Out</button>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container">
        <span style="font-size: 35px; font-weight: 10px;">Customer Contact Form</span>
         
        <c:if test = "${errorMessage}">
	        	<div>
	               <p class = "text-danger">
	                   ${error}
	               </p>
	           </div>
        </c:if>
        
        <form  action = "ProcessContactFormDataServlet" method = "post"> 
            <div class="form-group">
                <label for="fullName">*Name:</label>
                <input type="text" id="fullName" class="form-control" name="fullName" placeholder="John H.Smith" required">
                <small class="form-text text-muted text-left">Enter your full name</small>
            </div>
            <div class = "form-group">
                    <label for="fullName">*Gender:</label>
            </div>
            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline1" name="customRadioInline1" class="custom-control-input" value="male">
                <label class="custom-control-label" for="customRadioInline1">Male</label>
            </div>
            
            <div class="custom-control custom-radio custom-control-inline">
                <input type="radio" id="customRadioInline2" name="customRadioInline1" class="custom-control-input" value="female">
                <label class="custom-control-label" for="customRadioInline2">Female</label>
            </div>
            
            <div class="form-group">
                 <label for="category">*Category:</label>
                 <select class="form-control" id="category" name="category">
                     <option value="null">Select...</option>
                     <option value="feedback">Feedback</option>
                     <option value="inquiry">Inquiry</option>
                     <option value="complaint">Complaint</option>
                 </select>
             </div>
            <div class="form-group">
                <label for="message">*Message:</label><br>
                <textarea name="message" id="message" cols="80" rows="5"></textarea>
            </div>
            <div class = "form-group">
                 <button type="submit" id ="submit" class="btn btn-primary">Submit</button>
            </div>
            <footer>Hit count for this page: <c:out value = "${contact_form_HitCount}"></c:out> <span class = "float-right">Total hit count for the entire WebApp: <c:out value = "${totalHitCount}"></c:out> </span></footer>
        </form>

    </div>
</body>
</html>