<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/fonts/material-icon/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css">
<title>Registration</title>
</head>
<body>

<!-- <form:form id="regForm" modelAttribute="doctor" action="doctoraddprocess"
		method="post" class="text-center border border-light p-5" style="margin-left: 20%; margin-right: 20%;margin-top: 10%;box-shadow: 0 4px 8px 0 rgba(244, 83, 83, 0.9), 0 6px 20px 0 rgba(0, 0, 0, 0.19);">		
		<label style="font-size: 100;margin-bottom: 10%;font-size:40;font-family:none">Add Doctor</label>
		<form:input path="id" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="ID"></form:input>
		<form:input type="password" path="username" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Username"></form:input>
		<form:input type="password" path="type" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Type"></form:input>
		<form:input type="password" path="password" id="defaultLoginFormPassword" class="form-control mb-4" placeholder="Password"></form:input>
		<div class="d-flex justify-content-around">
        <div>
            <div >
                <div>${message}</div>
            </div>
        </div>
    </div>
		<div class="d-flex justify-content-around">
    </div>
		<form:button class="btn btn-info btn-block my-4" type="submit" style="background-color: #df5e5e">ADD</button></form:button>
	</form:form> -->


	<div class="main">

        <!-- Sign up form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="<%=request.getContextPath()%>/resources/images/signup-image.jpg" alt="sing up image"></figure>
                        
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Doctor</h2>
                        <p style=""color=red;">${message}</p>
                        <form:form method="POST" class="register-form" id="login-form" modelAttribute="doctor" action="doctoraddprocess">
                            
                            <div class="form-group">
                                <label for="your_id"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input type="text" name="your_id" id="your_id" placeholder="Doc_Id" path="id"/>
                            </div>
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input type="text" name="your_name" id="your_name" placeholder="Doc_Username" path="username"/>
                            </div>
                            <div class="form-group">
                                <label for="your_type"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input type="text" name="your_type" id="your_type" placeholder="Doc_Type" path="type"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <form:input type="password" name="your_pass" id="your_pass" placeholder="Doc_Password" path="password"/>
                            </div>
                            
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Submit"/>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
       </div>


<script src="<%=request.getContextPath()%>/resources/vendor/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/main.js"></script>
</body>