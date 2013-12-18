<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<p>
	<a href="<c:url value="/home" />" > Home</a> |

	<security:authorize url="/customer/">
		<a href='<c:url value="/customer/"/>'> Customer List</a> |
	</security:authorize>

	<a href="<c:url value="/product/" />" > Product List</a> |
	<a href="<c:url value="/product/sku/" />" > Search for Product by SKU</a> |
	
	<security:authorize url="/order/all/">
	<a href="<c:url value="/order/all/" />" > List All Orders</a> |
	</security:authorize>
	
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
</p>
