<%-- 
    Document   : addUser
    Created on : Jun 27, 2012, 4:53:25 PM
    Author     : yoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajout Utilisateur</title>
    </head>
    <body>
        <form action="" method="post">
            
            Nom: <input type="text" name="lastname" />
            Prenom: <input type="text" name="firstname"/>
            Email: <input type="text" name="email"/>
            Mot de passe: <input type="text" name="password">
            Confirmer mot de passe: <input type="text" name="confpass">
            
            <input type="submit" value="valider">
            
        </form>
    </body>
</html>
