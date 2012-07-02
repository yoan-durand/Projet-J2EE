

<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %> 


<html>
    <body>
        
         
         <% request.getRequestDispatcher("/index/connexion.htm").forward(request, response);

%>
         
    </body>
</html>
