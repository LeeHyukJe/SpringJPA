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
	
	<div>
		<c:if test="${pageMaker.prev }">
			<li><a href="listPage?page=${pageMaker.startPage-1 }">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
			<li>
				<a href="listPage?page=${idx }">${idx }</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
			<li><a href="listPage?page=${pageMaker.endPage +1 }">&raquo;</a></li>
		</c:if>
	</div>
</body>
</html>