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


<div class="main">

        <!-- Sign up form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="<%=request.getContextPath()%>/resources/images/signup-image.jpg" alt="sing up image"></figure>
                        
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Lab</h2>
                        <p style=""color=red;">${message}</p>
                        <form:form method="POST" class="register-form" id="login-form" modelAttribute="lab" action="labaddprocess">
                            
                            <div class="form-group">
                                <label for="your_id"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input type="text" name="your_id" id="your_id" placeholder="Lab_Id" path="id"/>
                            </div>
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input type="text" name="your_name" id="your_name" placeholder="Lab_name" path="name"/>
                            </div>
                            <div class="form-group">
                                <label for="your_type"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input type="text" name="your_type" id="your_type" placeholder="Lab_Type" path="type"/>
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