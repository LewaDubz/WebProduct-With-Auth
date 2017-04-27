<!DOCTYPE html>
<html lang="en">
<style>@import url(index.css);
@import url(backgroundVid.css);
video{filter: blur(25px);}
</style>
<video  id="bgvid" playsinline autoplay muted loop>
    <!-- WCAG general accessibility recommendation is that media such as background video play through only once. Loop turned on for the purposes of illustration; if removed, the end of the video will fade in the same way created by pressing the "Pause" button  -->
    <source src="./stringers%20(loop).mp4" type="video/webm">
    <source src= "./stringers%20(loop).mp4" type="video/mp4">

</video>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
</head>

<body><h1>Welcome tu the admin page</h1>
${Users}
</body>
</html>