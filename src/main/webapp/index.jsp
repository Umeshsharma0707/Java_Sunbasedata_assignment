<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Login Form</title>
    <style>
        body {
            background-color: #f8f9fa;
        }
        .login-container {
            margin-top: 5%;
        }
    </style>
</head>
<body>


<div class="container login-container">
    <div class="row justify-content-center">
        <div class="col-md-6 col-sm-8 col-lg-4">
            <div class="card">
            <!--                         wrong  message -->
                        <% String wrng = (String)request.getAttribute("wrng"); %>
                        <% if(wrng!=null){ %>
                        <p style="color: red; font-size: 16px">
                        <%out.print(wrng); %>
                        </br> try again
                        <%} %>
                        </p>
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0 text-center">Login</h4>
                </div>
                <h6>username : admin@gmail.com</h6>
                <h6>password : admin123</h6>
                <div class="card-body">
                    <form action="AdminController" method="post">
                        <div class="form-group">
                        
                        
<!--                         wrong email message -->
                        <% String wrngEmail = (String)request.getAttribute("wrngEmail"); %>
                        <% if(wrngEmail!=null){ %>
                        <p style="color: red; font-size: 16px">
                        <%out.print(wrngEmail); %>
                        </br> try again
                        <%} %>
                        </p>
                        
                        
                            <label for="username">Email id:</label>
                            <input type="email" class="form-control" id="username" name = "email" placeholder="Enter your email" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                        </div>
                        
<!--                         wrong password message -->
                        <% String wrngPass = (String)request.getAttribute("wrngPass"); %>
                        <% if(wrngPass!=null){ %>
                        <p style="color: red; font-size: 16px">
                        <%out.print(wrngPass); %>
                        </br> try again
                        <%} %>
                        </p>                        
                        
                        
                        
                        <button type="submit" class="btn btn-primary btn-block" name="action" value="login">Login</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
