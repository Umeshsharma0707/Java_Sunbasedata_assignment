<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Admin-dashboard</title>
    <style>
        body {
            background-color: #f8f9fa; /* Set the background color of the body */
        }
        .table-container {
            margin-top: 20px;
        }
        .table-responsive {
            background-color: black; /* Set the background color of the table */
            color: white; /* Set the text color */
        }
    </style>
</head>
<body>


 <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
               <a class="btn btn-primary" href="add-customer.jsp">Add Customer</a>
            </div>
            
            <form action="SearchController" method="post">
            
            <div class="col-md-6">
                <div class="form-group">
                    <label for="typeOption">Search By:</label>
                    <select name="searchby" class="form-control" id="typeOption">
                        <option value="firstname">First name</option>
                        <option value="city">City</option>
                        <option value="email">Email</option>
                        <option value="phone">Phone</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="searchBar">Search:</label>
                    <input type="text" class="form-control" id="searchBar" name="usersearch" placeholder="Search..." style="width: 250px"> 
                    <button type="submit" name="action" value="search" class="btn btn-primary">Search</button>
                </div>
            </div>
            
            </form>
            
        </div>
    </div>




<div class="container mt-4 table-container">
    <h2>Customer List</h2>
    <!-- customer added successfully message -->

<% String CustAddMsg = (String)request.getAttribute("CustAddMsg"); %>
<%if(CustAddMsg!=null){ %>
<p style="color: red; font-size: 16px">
<%out.print(CustAddMsg); %> </br>
you can add More customers
</p>
<%} %>

    <!-- customer Updated successfully message -->

<% String editMsg = (String)request.getAttribute("editMsg"); %>
<%if(editMsg!=null){ %>
<p style="color: red; font-size: 16px">
<%out.print(editMsg); %> </br>
you can update again
</p>
<%} %>

    <div class="table-responsive">
        <table class="table table-bordered table-dark">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>State</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Action</th>
                    
                    
                </tr>
            </thead>
            <tbody>
            
<!--             showing list of customers -->
				
            	<%List<Customer> list = CustomerDao.getAllCustomers(); %>
            	<%for(Customer c:list){ %>
                <tr>
                    <td><%=c.getFirst_name() %></td>
                    <td><%=c.getLast_name() %></td>
                    <td><%=c.getAddress() %></td>
                    <td><%=c.getCity() %></td>
                    <td><%=c.getState() %></td>
                    <td><%=c.getEmail() %></td>
                    <td><%=c.getPhone() %></td>
                    <td><a href="edit-customer.jsp?id=<%=c.getId()%>"><i class="fa fa-edit" style="font-size:24px;color:white"></i></a>
                    	&nbsp
                    	<a href="delete-customer.jsp?id=<%=c.getId()%>"><i class="fa fa-trash-o" style="font-size:25px;color:white"></i></a>
                    </td>
                    
                    
                </tr>
                <%} %>
                
            </tbody>
        </table>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
    