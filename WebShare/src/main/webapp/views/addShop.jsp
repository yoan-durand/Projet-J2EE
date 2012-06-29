<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<body>
	<h1>Spring MVC Hello World Annotation Example</h1>

	<h2><c:out value="${message}"/></h2>
        <a href="/" >Revenir à l'index</a>
        <ul>
        <c:forEach var="user" items="${users}">
            <li>${user.id} ${user.firstname} ${user.lastname}</li> 
        </c:forEach>
        </ul>

</body>
</html>