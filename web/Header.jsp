<%-- 
    Document   : Header
    Created on : May 28, 2021, 3:41:29 PM
    Author     : KhaTran
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="nav">
            <div class= "nav-inner">
                <ul>
                    <li> <a class="${active=="0"?"activeMenu":""}" href="HomeController">My front page</a></li>
                        <c:forEach items="${top3}" var="i" >
                        <li> <a class="${active==i.id?"activeMenu":""}" href="GalleryController?galeryId=${i.id}">${i.name}</a> </li>
                        </c:forEach>
                    <li> <a class="${active=="4"?"activeMenu":""}" href="ContactController">Contact</a> </li>
                </ul> 
            </div>

        </div>
        <div class="header">
            <div class="header-inner">
                <div class="img"></div>
                
                <div class="title ">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>
    </body>
</html>
