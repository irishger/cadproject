<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
   
</head>

<body>


<jsp:include page="header.jsp" />

	<p><a href='<c:url value="/customer/add"/>'>Add Customer</a></p>

	<p>Customer List:</p>
	
	<c:forEach var="cust" items="${customers}">
		<p><a href='<c:url value="/customer/${cust.id}/"/>'>${cust.firstName} ${cust.secondName}</a></p>
	</c:forEach>
	
</body>
</html>
