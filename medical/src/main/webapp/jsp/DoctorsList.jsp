<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome</title>
</head>
<body>
<div align="center">
           <h1>Doctor List</h1>
           <h3><a href="doctoradd">Add Doctor</a></h3>
           <table border="1" cellpadding="5">
             <tr>
                  <th>SlNo.</th>
                  <th>UserID</th>
                  <th>Name</th>
                  <th>Department</th>
                  <th>Password</th>
                  <th>Action</th>
             </tr>
             <c:forEach items="${doctorslist}" var="doctor" varStatus="status">
             <tr>
                 <td>${status.index +1}</td>
                 <td>${doctor.id}</td>
                 <td>${doctor.username}</td>
                 <td>${doctor.type}</td>
                 <td>${doctor.password}</td>
                 <td>
                      <a href="doctoredit/${doctor.id }">Edit</a>
                      &nbsp;&nbsp;
                      <a href="doctordelete/${doctor.id }">Delete</a>
                      
                 </td>     
             
             
             
             </c:forEach>
             
             </table>
</div>
</body>
</html>

             
             
                  
                  