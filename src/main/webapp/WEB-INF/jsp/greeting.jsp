<!DOCTYPE html>
<html>
<head>
    <title>Chat - Customer Module</title>
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
</head>

<div id="wrapper">
    <div id="menu">
        <p class="welcome">Welcome, <b></b></p>
        <p class="logout"><a id="exit" href="#">Exit Chat</a></p>
        <div style="clear:both"></div>
    </div>

    <div id="chatbox"></div>

    <form name="message" action="">
        <input name="usermsg" type="text" id="usermsg" size="63" />
        <input name="submitmsg" type="submit"  id="submitmsg" value="Send" />
    </form>
</div>

</body>
</html>