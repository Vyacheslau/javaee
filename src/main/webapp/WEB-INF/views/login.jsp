<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EO: Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="/organization/resources/assets/css/common.css">
</head>
<body>
	<div id="wrapper">
		<div id="header"></div>
		<div id="nav">
			<p>The best abilities to perform best practices</p>
		</div>
		<div id="content" class="clearfix">
			<div id="col_1">
				<!-- <h2>Information</h2> -->
				<spring:url value="/login/check" var="url" />
				<form:form action="${url}" method="post" commandName="user">
					<ul id="subnav">
						<li>Login</li>
						<li><form:input id="login" type="text"
								cssClass="login-fields" path="login" /></li>
						<li>Password</li>
						<li><form:input id="password" type="password"
								cssClass="login-fields" path="password" /></li>
						<li><input id="login" type="submit" value="Login"
							class="button" /></li>
					</ul>
				</form:form>
			</div>
			<div id="col_2">
				<h2>Welcome to Enterprise Organization</h2>
				<br>
				<h4>Develop your success in organization management with us!</h4>
				<br> <img
					src="/organization/resources/assets/images/images.gif" width="530"
					height="370" align="middle" />

				<blockquote>The system is desined and developed by
					Vyacheslau Karachun and contains several useful features.</blockquote>
			</div>
		</div>
		<c:import url="footer.jsp" charEncoding="UTF-8"></c:import>
	</div>
</body>
</html>