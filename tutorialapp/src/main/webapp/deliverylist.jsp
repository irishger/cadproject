<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
   
</head>

<body>


<jsp:include page="header.jsp" />

	

	<p>Delivery List:</p>
	
	<c:forEach var="dill" items="${delivery}">
		<p><a href='<c:url value="/delivery/${dill.deliveryID}/"/>'>${dill.firstName} ${dill.secondName}</a></p>
	</c:forEach>
	
</body>
</html>
