<%@page import="dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete customer</title>
</head>
<body>

<% int id = Integer.parseInt(request.getParameter("id")); %>
<% CustomerDao.deleteCustomer(id); %>
<% response.sendRedirect("admin-dashboard.jsp"); %>

</body>
</html>