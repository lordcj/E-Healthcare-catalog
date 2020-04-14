<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<div class="container">Hi ${id }</div>
	<c:if test="${not empty doctors}">
    <c:forEach var="doctor" items="${doctors}" varStatus="status">
        <div class="container">
	        <div>    
	            <div>${doctor.id}</div>
	            <div>${doctor.username}</div>
	            <div>${doctor.type}</div>
	             
        	</div>
			<div>
				<form:form id="booked${status.index }" action="doctorbookingprocess" method="post" modelAttribute="bookedslots" >
					<form:select path="bookedslot" >
						<form:options items="${slots[status.index] }" />
					</form:select>
					<form:input type="hidden" path="patientid" value="${id }" />
					<form:input type="hidden" path="id" value="${doctor.id }" />
		 			<input type="submit" name="Submit" value="Submit" tabindex="2" />
				</form:form>
			</div>
		</div>
    </c:forEach>
</c:if>
</body>