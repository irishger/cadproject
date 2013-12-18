<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
   
</head>

<body>
	<p>Hello, World!</p>
	
	<c:if test="${debug == 'true'}">
		<p>The time is: ${dateOut}</p>
	</c:if>

</body>
</html>
