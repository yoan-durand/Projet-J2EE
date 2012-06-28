<%-- 
    Document   : navigator
    Created on : Jun 28, 2012, 3:14:21 AM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="../Css/site.css" rel="stylesheet" type="text/css" />
        <link href="../Css/navigator.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Navigator</title>
    </head>
    <body>
        <section id="page">
            <%@ include file="/WEB-INF/jsp/include.jsp" %>
            <h1 class="float-left">Web Share</h1>
            <div id="connect_zone" class="float-right">
                <strong > Bienvenue LOGIN </strong><img src="down_arrow" alt="pick"/>
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
            <a><img id="back_button" class="float-left" src="back_button" alt="back"/></a>
            <ul id="path" class="float-left">
                <li class="path_item float-left"> Epita </li>
                <li class="path_limit float-left"><img class="path_sep" src="path_next" alt=">"</li>
                <li class="path_item float-left"> Java Project </li>
                <li class="path_limit float-left"> </li>
            </ul>
             <input id="search_bar" class="float-right"/>
            <img id="share_button" class="tool_button float-right" alt="share"/>
            <img id="show_deleted" class="tool_button float-right" alt="deleted"/>
            <img id="upload" class="tool_button float-right" alt="upload"/>
            <img id="create_folder" class="tool_button float-right" alt="Create_folder"/>
            
           
            <ul class="clear" id="file_list">
                <li class="file_item">
                    <strong class="file_name float-left">Nom</strong>
                    <strong class="file_type float-left">Type</strong>
                    <strong class="file_modification float-left">Modification</strong>
                    <strong class="file_visibility float-left">Visibilité</strong>
                    <br class="clear"/>
                </li>
                <li class="file_item">
                    <span class="file_name float-left">hello world.txt</span >
                    <span  class="file_type float-left">.txt file</span >
                    <span  class="file_modification float-left">01/01/2012</span >
                    <span  class="file_visibility float-left">private</span >
                    <br class="clear"/>
                </li>
                <c:forEach var="bean" items="${listpers}">
                    <li class="file_item">
                        <span class="file_name float-left">${bean.name}</span >
                        <span  class="file_type float-left">${bean.type}</span >
                        <span  class="file_modification float-left">${bean.modification}</span >
                        <span  class="file_visibility float-left">${bean.visibility}</span >
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
