<%-- 
    Document   : Gallery
    Created on : May 28, 2021, 3:41:39 PM
    Author     : KhaTran
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${galery.name}</h3>
                    </div>
                    <c:if test="${top1Gallery.imageUrl != null && totalRecord > 0}">
                        <div class="main-img" id="thumbnail">
                            <div id="g-main-img" class="a-main-img">
                                <img class="main-image" id="FImg" src="image/${top1Gallery.imageUrl}" alt="ccc"/>
                            </div>
                            <img id="play" class="play" src="image/play.png" alt="ccc"/> 
                        </div>
                    </c:if>
                    <div class="contentGalery">
                        <ul >
                            <c:forEach items="${listImage}" var="i" varStatus="loop">
                                <li class="span4">
                                    <img id="support-image${i.id}" src="image/${i.imageUrl}"  alt="/" onclick="display(${i.id})">
                                </li>
                            </c:forEach>
                        </ul>    
                        <div class="paging">

                            <c:forEach begin="1" end="${maxPage}" var="i">
                                <a class="${i==index?"active":""}" href="GalleryController?index=${i}&galeryId=${galeryID}">${i}</a>
                                <c:set var="index" value="${index}" />
                            </c:forEach>

                        </div>
                    </div>
                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
        <script>
            var index = 1;
            var timeNext;
            document.getElementById('thumbnail').onmouseover = function () {
                playButton.style.opacity = "100";
            }
            document.getElementById('thumbnail').onmouseout = function () {
                playButton.style.opacity = "0";
            }
            changeImage = function () {
                var listImage = [];
            <c:forEach items="${listImage}" var="i">
                listImage.push("${i.imageUrl}");
            </c:forEach>
                document.getElementById('FImg').src = "image/" + listImage[index];
                index++;
                if (index == listImage.length) {
                    index = 0;
                }
            }
            var playing = false;
            var playButton = document.getElementById('play');
            function play() {
                playButton.src = "image/pause.png";
                playing = true;
                timeNext = setInterval(changeImage, 1000);               
            }
            function pause() {
                playButton.src = "image/play.png";
                playing = false;
                clearInterval(timeNext);               
            }   
            playButton.onclick = function () {               
                if (playing == true) {                   
                    pause();                     
                } else {
                    play();                      
                }
            }
            function display(index){
                var urlDislay = document.getElementById("support-image"+index);
                document.getElementById('FImg').src = urlDislay.src;
            }
        </script>
    </body>
</html>
