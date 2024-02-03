<%@page import="dao.SearchDao"%>
<%@page import="model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>

<div class="container mt-4 table-container">

<!--             showing list of customers -->
<% String email = (String)request.getAttribute("email"); %>
    <h2>Customer By email : <h1> <% out.print(email); %></h1> </h2>
    <!-- customer added successfully message -->


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
            

				
            	<% List<Customer> list = SearchDao.getByEmail(email); %>
            	<%for(Customer c: list){ %>
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
                
                <%if(list.isEmpty()){ %>
                <p style="color: red; font-size: 20px"><%out.print("No data found with Email : " + email); %></p>
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