<%@page import="model.Customer"%>
<%@page import="dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <title>Edit Customer</title>
</head>

<body>
<%int id = Integer.parseInt(request.getParameter("id")); %>
<% Customer c1 = (Customer)CustomerDao.getCustomerById(id); %>

    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center mb-4">Edit Customer</h2>
                <form action="CustomerController" method="post">
                    <div class="form-row">
                    
<!--                     customer id -->
                    <input type="hidden" class="form-control" name="id" value="<%=c1.getId()%>">
                        <div class="form-group col-md-6">
                            <label for="firstName">First Name:</label>
                            <input type="text" class="form-control" id="firstName" name="firstname" value="<%=c1.getFirst_name() %>" placeholder="Enter first name" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="lastName">Last Name:</label>
                            <input type="text" class="form-control" id="lastName" name="lastname" value="<%=c1.getLast_name() %>" placeholder="Enter last name" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="city">Street:</label>
                            <input type="text" class="form-control" id="city" name="street" value="<%=c1.getStreet() %>" placeholder="Enter Street" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="state">Address:</label>
                            <input type="text" class="form-control" id="state" name="address" value="<%=c1.getAddress() %>" placeholder="Enter Address" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="city">City:</label>
                            <input type="text" class="form-control" id="city" name="city" value="<%=c1.getCity() %>" placeholder="Enter city" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="state">State:</label>
                            <input type="text" class="form-control" id="state" name="state" value="<%=c1.getState() %>" placeholder="Enter state" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" value="<%=c1.getEmail() %>" placeholder="Enter email" required>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone Number:</label>
                        <input type="tel" class="form-control" id="phone" name="phone" value="<%=c1.getPhone() %>" placeholder="Enter phone number" required>
                    </div>
                    <button type="submit" class="btn btn-primary" name="action" value="edit customer">Edit Customer</button>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>

</html>
    