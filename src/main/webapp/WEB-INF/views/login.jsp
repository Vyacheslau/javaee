<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Minisite Pro</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="/organization/resources/assets/css/common.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<!--<a href="index.htm"><img src="assets/images/logo_header.gif" alt="" width="203" height="102" class="logo" /></a> -->
		</div>
		<ul id="nav">
			<li><a href="http://web-mastery.info/">Example One</a></li>
			<li><a href="http://web-mastery.info/">Example Two</a></li>
			<li><a href="http://web-mastery.info/">Example Three</a></li>
			<li><a href="http://web-mastery.info/">Example Four</a></li>
		</ul>
		<div id="content" class="clearfix">
			<div id="col_1">
				<!-- <h2>Information</h2> -->
				<spring:url value="/login/check" var="url" />
				<form:form action="${url}" method="post" commandName="user">
					<ul id="subnav">
						<li>Login</li>
						<li><form:input id="login" type="text" cssClass="login-fields" path="login" /></li>
						<li>Password</li>
						<li><form:input id="password" type="password" cssClass="login-fields" path="password" /></li>
						<li><input type="submit" value="Login"
							style="width: 125px; height: 20px" /></li>
					</ul>
				</form:form>
			</div>
			<div id="col_2">

				<h1>Example Headline One</h1>
				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
					Integer pede. Aliquam facilisis. Nulla gravida elit at eros. Nunc
					arcu. In urna velit, gravida ut, venenatis id, suscipit ut, massa.
					Proin bibendum luctus turpis. Nam porttitor ante ut leo. Integer
					luctus venenatis sem. Maecenas non ante. Ut semper. Duis vel velit.
					Ut porta. Etiam rutrum purus at mauris molestie aliquam.
					Pellentesque ornare. Aenean convallis dictum quam. Etiam sodales
					magna in mi. Phasellus risus nunc, lacinia sit amet, accumsan sed,
					blandit et, orci. Nulla id augue et nibh tincidunt convallis. Fusce
					euismod neque vel sem. Sed et turpis in nisl interdum tincidunt.</p>
				<h2>Example Headline Two</h2>
				<blockquote>This would obviously be an example
					blockquote. Lorem ipsum dolor sit amet, consectetuer adipiscing
					elit. Integer pede. Lorem ipsum dolor sit amet, consectetuer
					adipiscing elit. Integer pede.</blockquote>
				<h3>Example Headline Three</h3>
				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.
					Integer pede. Aliquam facilisis. Nulla gravida elit at eros. Nunc
					arcu. In urna velit, gravida ut, venenatis id, suscipit ut, massa.</p>
				<p>Proin bibendum luctus turpis. Nam porttitor ante ut leo.
					Integer luctus venenatis sem. Maecenas non ante. Ut semper. Duis
					vel velit. Ut porta. Etiam rutrum purus at mauris molestie aliquam.
					Pellentesque ornare. Aenean convallis dictum quam. Etiam sodales
					magna in mi. Phasellus risus nunc, lacinia sit amet, accumsan sed,
					blandit et, orci. Nulla id augue et nibh tincidunt convallis. Fusce
					euismod neque vel sem. Sed et turpis in nisl interdum tincidunt.</p>
			</div>
		</div>
		<div id="footer">
			<small>All content copyright &copy; 2006 Your Site, all
				rights reserved.<br /> Layout by <a
				href="http://cssweblayouts.com/" target="_blank">CSS Web Layouts</a>
			</small>
		</div>
	</div>
</body>
</html>