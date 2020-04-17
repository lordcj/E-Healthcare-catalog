<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
</head>
<body>
	
	<div class="d-flex justify-content-around" style="margin-top:20%" >
		<div style="font-size: xxx-large;text-align: center;width: 100%;">
    		<a href="patientloginandsignup" style="text-decoration: none">Patient</a>
		</div>
        <div style="font-size: xxx-large;text-align: center;width: 100%;">
            <a href="doctorlogin" style="text-decoration: none">Doctor</a>
        </div>
        <div style="font-size: xxx-large;text-align: center;width: 100%;">
            <a href="adminlogin" style="text-decoration: none">Administrator</a>
        </div>
    </div>
	
</body>
</html>