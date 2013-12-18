<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product page</title>
</head>
<body>
	
	<jsp:include page="header.jsp" />
	
	<h3>Product List:</h3>
	<p>
	<c:forEach var="prod" items="${products}">
		<p>${prod.sku} ${prod.name} ${prod.description}  
		<a href='<c:url value="/product/${prod.sku}"/>'>View Product Details</a> | 
		
		<security:authorize url="/product/invoice/*">
			<a href='<c:url value="/order/add/${prod.sku}"/>'>Add Product to Order</a> 
		</security:authorize>
		
		</p>
	
	</c:forEach>

	</p>

	<security:authorize url="/product/add/*">
		<a href='<c:url value="/product/add"/>'>Add Product</a>
	</security:authorize>
	
</body>
</html>