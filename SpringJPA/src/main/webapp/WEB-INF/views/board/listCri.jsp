<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>listCri</title>
</head>
<body>
	<c:forEach items="${list }" var="list">
		<div>${list.bno } ${list.title } ${list.content }</div>
		
	</c:forEach>
</body>
</html>