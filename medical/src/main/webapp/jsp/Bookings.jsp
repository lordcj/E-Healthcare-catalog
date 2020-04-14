<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
<title>Welcome</title>
</head>
<body>
	<div class="container">
		<c:forEach var="slot" items="${bookedslots}" varStatus="status">
			<div>
				<div>${slot.id }</div>
				<div>${slot.bookedslot }</div>
			</div>
		</c:forEach>
	</div>
</body>