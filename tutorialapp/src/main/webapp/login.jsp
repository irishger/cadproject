<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 
	<h3>Please Log In</h3>
 
	<c:if test="${not empty errorMsg}">
		<div style="color:red;font-weight:bold;">
			Login attempt unsuccessful.<br />
		</div>
	</c:if>
 
	<form action="<c:url value='j_spring_security_check' />" method='post'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' />
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' />
				</td>
			</tr>
			<tr>
				<td colspan='2'><input name="login" type="submit" value="Login" />
				</td>
			</tr>
		</table>
 
	</form>
