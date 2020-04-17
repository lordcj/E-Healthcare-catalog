<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	
	<div class="d-flex justify-content-around" style="margin-top:20%" >
		<div style="font-size: xxx-large;text-align: center;width: 100%;">
    		<a href="doctors" style="text-decoration: none">Doctors</a>
		</div>
        <div style="font-size: xxx-large;text-align: center;width: 100%;">
            <a href="labs" style="text-decoration: none">Labs</a>
        </div>
        <div style="font-size: xxx-large;text-align: center;width: 100%;">
            <a href="home.jsp" style="text-decoration: none">Home</a>
        </div>
    </div>

</body>
</html>