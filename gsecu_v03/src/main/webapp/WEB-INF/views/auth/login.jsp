<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<div style="text-align:center">
	<h2>Login!</h2><br>
	<form name="loginForm" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<table style="margin-left:auto; margin-right:auto;">
			<tr>
				<td>User:</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
			<td>Password:</td>
				<td><input type="password" name="userpw"></td>
			</tr>
			<!-- <tr>
				<td></td>
				<td>Remember Me: <input type="checkbox" name="remember-me" /></td>
			</tr> -->
			<c:if test="${not empty failmsg and failmsg != null}">
			<tr>
				<td></td>
				<td>${failmsg}</td>
			</tr>
			</c:if>
			<tr>
				<td></td>
				<td>
					<input name="submit" type="submit" value="Login" />
				</td>
			</tr>
		</table>
	</form>
	<a href="<c:url value='/'/>">INDEX</a>
</div>
</body>
</html>