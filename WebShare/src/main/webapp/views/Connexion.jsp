<%-- 
    Document   : Connexion
    Created on : Jun 29, 2012, 3:09:37 AM
    Author     : yoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <h2>Bienvenue sur WebShare</h2>
        
        <form action="" method="post">
            login : <input type="text" name="login"/>
            password : <input type="text" name="password" />
            <input type="submit" value="connexion" />
        </form>
        
        <a href="/user/Inscription.htm" > creer un compte</a>
        <a href="/File/navigator.htm"> Files navigator </a>
        <a href="/user/Utilisateurs.htm" > Utilisateurs</a>
        <a href="/File/upload.htm" > Upload</a>
        <a href="/File/download.htm" > Download</a>
        <a href="/File/myDirectory.htm" > Mon répertoire</a>
        
    </body>
</html>
