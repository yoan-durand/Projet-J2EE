<%@ include file="/WEB-INF/jsp/include.jsp" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! it is now <c:out value="${now}"/></h1>
        <a href="other.htm" > Autre Action du Controller Test</a>
    </body>
</html>
