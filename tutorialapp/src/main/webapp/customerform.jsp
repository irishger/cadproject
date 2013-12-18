<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
   
</head>

<body>


<jsp:include page="header.jsp" />

	<c:url value="/customer/" var="form_url"/>
	<form:form action="${form_url}" commandName="customer">
	
		First name: <form:input path="firstName" size="30" /><br/>
		Last name: <form:input path="secondName" size="30" /><br/>
		Address 1:<form:input path="address1" size="50" /><br/>
		Address 2:<form:input path="address2" size="50" /><br/>
		Address 3:<form:input path="address3" size="50" /><br/>
		Credit Limit:<form:input path="creditLimit" size="15" /><br/>
		<form:hidden path="id" />
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>
