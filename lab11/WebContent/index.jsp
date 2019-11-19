<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer Contact App</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
                    <a class="nav-link" href="ProcessContactFormDataServlet">Contact Us <span class="sr-only">(current)</span></a>
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
	<div class = "container">
		<div class="jumbotron">
  			<h1 class="display-4">Hello, world of HttpServlet 4.0!</h1>
  			<p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
 			<hr class="my-4">
  			<p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
 			<a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
		</div>
	</div>
</body>
</html>