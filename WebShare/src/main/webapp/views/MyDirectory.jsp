<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mon espace</title>
    </head>
    <body>
        <h1>Mes dossiers</h1>
        <ul>
            <c:forEach  var="userfile" items="${userfiles}">
                <li>${userfile.getFile().getName()}</li>
            </c:forEach>
        </ul>
    </body>
</html>
