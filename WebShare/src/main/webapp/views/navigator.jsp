<%-- 
    Document   : navigator
    Created on : Jun 28, 2012, 3:14:21 AM
    Author     : vince
--%>
<%@page import="com.mti.webshare.model.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="../Css/site.css" rel="stylesheet" type="text/css" />
        <link href="../Css/navigator.css" rel="stylesheet" type="text/css" />
        <script src="../Js/navigator.js" type="text/javascript"></script>
        <script src="../Js/jquery-1.7.2.min.js" type="text/javascript"></script>  
        <script src="../Js/jquery-ui-1.8.21.custom.min.js" type="text/javascript"></script>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Navigator</title>
    </head>
    <body>
        <section id="page">
            <%@ include file="/WEB-INF/jsp/include.jsp" %>
            <h1 class="float-left">Web Share</h1>
            <div id="connect_zone" class="float-right">
                <strong > Bienvenue
                    <% User user = (User)request.getSession().getAttribute("user");
                          out.print(user.getFirstname()+" "+ user.getLastname());%>
                </strong>
                <img src="down_arrow" alt="pick"/>
            </div> 
            <ul id="menu" class="clear">
                <li class="menu_item float-left">
                    <a href=""> Navigation </a>
                </li>
                <li class="menu_item float-left">
                    <a href=""> Evénements </a>
                </li>
                <li class="clear"></li>
            </ul>
            <a><img id="back_button" class="float-left" src="../Images/old_edit_undo.png" alt="back"/></a>
            <ul id="path" class="float-left">
                <li class="path_item float-left"><a href=""> Epita </a></li>
                <li class="path_limit float-left"><img class="path_sep" src="../Images/old_go_next.png" alt=">"</li>
                <li class="path_item float-left"><a href=""> Java Project </a></li>
                <li class="path_limit float-left"> </li>
            </ul>
             <input id="search_bar" class="float-right"/>
            <img id="share_button" class="tool_button float-right" src="../Images/sharemanager.png" alt="share"/>
            <img id="show_deleted" class="tool_button float-right" src="../Images/archive_remove.png" alt="deleted"/>
            <img id="create_folder" class="tool_button float-right" src="../Images/folder_add.png" alt="Create_folder"/>
            <img id="upload" class="tool_button float-right" src="../Images/box_upload.png" alt="upload"/>
            
           
            <ul class="clear" id="file_list">
                <li class="file_item file_schema">      
                    <strong class="file_name float-left">Nom</strong>
                    <strong class="file_type float-left">Type</strong>
                    <strong class="file_modification float-left">Modification</strong>
                    <strong class="file_visibility float-left"> Visibilité </strong>
                    <br class="clear"/>
                </li>
                <li class="file_item">
                    <span class="file_name float-left"><img class="file_logo float-left" src="logo" /> hello world.txt</span >
                    <span  class="file_type float-left">.txt file</span >
                    <span  class="file_modification float-left">01/01/2012</span>
                    <span  class="file_visibility float-left">private</span >
                    <br class="clear"/>
                </li>
              <c:forEach var="file" items="${list_file}">
                    <li class="file_item">
                        <span class="file_name float-left">${file.name}</span>
                        <span  class="file_type float-left">${file.type}</span>
                        <span  class="file_modification float-left">${file.modif_date}</span >
                         <span  class="file_visibility float-left">${file.visibility}</span >
                        <br class="clear"/>
                    </li>
                </c:forEach>
            </ul>
            <ul id="index">
                <li class="index_number"></li>
            </ul>
            <div id="who_share" class="float-right">
                Qui partage ce dossier?
            </div>
        </section>
    </body>
</html>
