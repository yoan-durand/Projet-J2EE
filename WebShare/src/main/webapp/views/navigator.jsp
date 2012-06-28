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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Navigator</title>
    </head>
    <body>
        <h1 class="float-left">Web Share</h1>
        <div id="connect_zone" class="float-right">
            <strong > Bienvenue LOGIN </strong><img src="down_arrow" alt="pick"/>
        </div>
        <ul id="menu" class="clear">
            <li class="menu_item">
                Navigation
            </li>
            <li class="menu_item">
                Evénements
            </li>
        </ul>
        <a><img src="back_button" alt="back"/></a>
        <ul id="path">
            <li class="path_item"> Epita </li>
            <li class="path_limit"></li>
            <li class="path_item"> Java Project </li>
            <li class="path_limit"></li>
        </ul>
        <ul id="button_panel">
            <li class="action_button"><a></a></li>
        </ul>
        <input class="search_bar"/>
        <ul id="file_list">
            <li class="file_schema">
                <span class="file_name">Nom</span>
                <span class="file_type">Type</span>
                <span class="file_modification">Modification</span>
                <span class="file_visibility">Visibilité</span>
            </li>
            <li class="file_item"><li>
        </ul>
        <ul id="index">
            <li class="index_number"></li>
        </ul>
        <div id="who_share"></div>
    </body>
</html>
