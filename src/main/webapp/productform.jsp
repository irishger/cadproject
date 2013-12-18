<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
   
</head>

<body>
<jsp:include page="header.jsp" />

<h2>Add a new Product</h2>
	<form action='<c:url value="/product/"/>' method="POST">
	
		SKU ID: <input type="text" name="sku" size="10"><br/>
		Product name: <input type="text" name="name" size="30"><br/>
		Description:<input type="text" name="description" size="50"><br/>
		Price Per Unit:€<input type="text" name="pricePerUnit" size="6"><br/>
		Unit Description:<input type="text" name="unitDescription" size="50"><br/>
		Stock Level:<input type="text" name="stockLevel" size="5"><br/>
		<input type="submit"/>
	</form>
</body>
</html>