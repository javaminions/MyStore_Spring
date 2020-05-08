<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-In</title>
<link rel="stylesheet" href="styles/register.css" type="text/css"/>
 <script src="scripts/login.js" charset="utf-8"></script>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="registrationContainer">
<h1>Have an account already?</h1>
<h2>Sign in below!</h2>


<br><br><br>

<div id="registration">
<form action="IndexHandler" method="post" id="login">
    <input required type="hidden" name="action" value="signin">        
    <label class="pad_top">Username:</label>
    <input required type="text" name="userName"><br><br>
     
    <label class="pad_top">Password:</label>
    <input required type="password" name="password"> <br> <br>
    <label>&nbsp;</label><br>
    <input required type="submit" value="Sign In" class="margin_left">
</form>
</div>
<br>
<p>Don't have an account?</p>
<form action="IndexHandler">
<input type="hidden" name="action" value="registerPage">
<input type="submit" value="Register" class="margin_left">
</form>
</div>


<jsp:include page="Footer.html"/>
</body>
</html>