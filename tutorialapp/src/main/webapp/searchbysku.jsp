<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search for Product by SKU</title>
</head>
<body>
<jsp:include page="header.jsp" />

	<form action='<c:url value="/product/sku/"/>' method="POST">
		
		Enter the SKU of the product: <form:input type="text" path="product.sku" size="5" />
									  	
		<input type="submit" value="Search" />
	</form>
	
</body>
</html>