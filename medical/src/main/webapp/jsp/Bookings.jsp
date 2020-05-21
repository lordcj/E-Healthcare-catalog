<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/3/w3.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
<title>Welcome</title>
</head>
<body>
	<!-- Navigation -->
	<nav class="w3-bar w3-black">
  		<a href="home.jsp" class="w3-button w3-bar-item">Home</a>
  		<a href="adminlogin" class="w3-button w3-bar-item">Administrator</a>
  		<a href="doctorlogin" class="w3-button w3-bar-item">Doctor</a>
  		<a href="patientloginandsignup" class="w3-button w3-bar-item">Patient</a>
	</nav> 
	<p> The booked slots with doctor are as follows: </p>
	<div class="container">
		<c:forEach var="slot" items="${bookedslots}" varStatus="status">
			<div>
				<div>${slot.id }</div>
				<div>${slot.bookedslot }</div>
			</div>
		</c:forEach>
	</div>
	<p> The booked slots in labs are as follows: </p>
	<div class="container">
		<c:forEach var="slot" items="${bookedlabslots}" varStatus="status">
			<div>
				<div>${slot.id }</div>
				<div>${slot.bookedlabslot }</div>
			</div>
		</c:forEach>
	</div>
</body>