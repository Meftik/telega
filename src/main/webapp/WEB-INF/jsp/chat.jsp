<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chat - Customer Module</title>
    <style type="text/css">
        <%@include file="../../resources/css/style.css" %>
    </style>users
</head>
<div class="block-left">

    <form action="users" method="get">
        <table border="1">
            <tr>
                <th>Friends</th>
            </tr>
            <c:forEach items="${users}" var="user" >
            <tr>
                <td>${user.getUsername()}</td>

            </tr>
            </c:forEach>
        </table>
    </form>
</div>
<form method="POST" action="${contextPath}/chat" class="form-signin">
<div id="wrapper">
    <div id="menu">
        <p class="welcome">Welcome,${message} <b></b></p>

        <p class="logout"><a id="exit" href="#">Exit Chat</a></p>
        <div style="clear:both"></div>
    </div>

    <div id="chatbox" class="block-right">
        <c:forEach items="${usermessage}" var="usermsg" >

        <p class="p">${usermsg.getMessage()}</p>
        </c:forEach>
    </div>


        <input name="usermsg" type="text" id="usermsg" size="63" />
        <input name="submitmsg" type="submit"   value="submitmsg" />

</div>
</form>
</body>
</html>