<%-- 
    Document   : Right
    Created on : May 28, 2021, 1:00:32 PM
    Author     : KhaTran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header-right">
            <h4>Share this page</h4>
        </div>
        <div class="social">
            <ul>
                <li><img src="image/${contact.facebookIcon}"><a href="${contact.facebookUrl}"><span>Share on Facebook</span></a></li>
                <li><img src="image/${contact.twitterIcon}"><a href="${contact.twitterUrl}"><span>Share on Twitter</span></a></li>
                <li><img src="image/${contact.googleIcon}"><a href="${contact.googleUrl}"><span>Share on Google</span></a></li>
            </ul>
        </div>
    </body>
</html>
