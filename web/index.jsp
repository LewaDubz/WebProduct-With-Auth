<%--
  Created by IntelliJ IDEA.
  User: byteforce
  Date: 2017.04.07.
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <style>@import url(index.css);
    @import url(backgroundVid.css);
    video{filter: blur(25px);}
    </style>
  <video  id="bgvid" playsinline autoplay muted loop>
    <!-- WCAG general accessibility recommendation is that media such as background video play through only once. Loop turned on for the purposes of illustration; if removed, the end of the video will fade in the same way created by pressing the "Pause" button  -->
    <source src="./stringers%20(loop).mp4" type="video/webm">
    <source src= "./stringers%20(loop).mp4" type="video/mp4">

  </video>
      <title>
   </title>
  </head>

  <body>

  <h1>Please consider buying my music so I wouldn't starve to death.
  </h1>
  <iframe width="100%" height="450" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?url=https%3A//api.soundcloud.com/tracks/318098996&amp;auto_play=false&amp;hide_related=false&amp;show_comments=true&amp;show_user=true&amp;show_reposts=false&amp;visual=true"></iframe>
  <form action="Servlet" method="post">
      ${PurchaseThanks}
  <input type="submit" value="buy" name ="button">
  </form>
  <p>Also please subscribe to the newsletter so you can stay informed on news about my projects</p>
  <form action="Servlet" method="post" >
      E-mail:<br>
      <input type="email" name="email" value="email">
      <br>
      Password:<br>
      <input type="password" name="password" value="password">
      <br><br>
      <input type="submit" value="register" name ="button" >
      <input type="submit" value="login" name="button">
  </form>
  ${RegisterDetails}
  </body>
</html>
