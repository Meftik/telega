<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chat - Customer Module</title>
    <style type="text/css">
        <%@include file="../../resources/css/style.css" %>
    </style>
</head>
<div class="block-left">

    <form action="friends" method="get">
        <input name="findUser" type="text"   autofocus="true"/>
        <p>${message1}</p>
        <input  name="Add" type="submit" value="Add" />

        <table border="1">
            <tr>
                <th>Friends</th>
            </tr>
         <c:forEach items="${friends}" var="friend1" >
            <tr>
                <td>
                    <input name="friend1" type="hidden"   value="${friend1.getFriends()}" />
                    <input name="choose" type="submit"   value="${friend1.getFriends()}" />
                    <input name="Delete" type="submit"   value="Delete" />
                    <c:if test="${friend1.isAdd() eq false}">

                       <p> Add friend? <p/>

                        <input name="Yes" type="submit"   value="Yes" />

                    </c:if>
                </td>


            </tr>
            </c:forEach>
        </table>
    </form>
</div>
<form method="POST" action="${contextPath}/chat" class="form-signin">
<div id="wrapper">
    <div id="menu">
        <p class="welcome">Welcome,${message} <b></b></p>

        <p class="logout"><a id="exit" href="${contextPath}/login">Exit Chat</a></p>

    </div>

    <div id="chatbox" class="block-right">

<c:set var="bool" value="true"/>
        <c:set var="bool2" value="true"/>
        <c:forEach items="${usermessage}" var="usermsg" >
<c:if test="${usermsg.getFrom().equals(user1.getUsername())}">
            <c:if test="${bool eq true}">
    <p class="p2">You:</p>
                <c:set var="bool" value="false"/>
                <c:set var="bool2" value="true"/>
            </c:if>
    <p class="p">${usermsg.getMessage()}</p>
</c:if>
            <c:if test="${!usermsg.getFrom().equals(user1.getUsername())}">
                <c:if test="${bool2 eq true}">
                    <p class="p3">${user2.getUsername()}:</p>
                    <c:set var="bool2" value="false"/>
                    <c:set var="bool" value="true"/>
                </c:if>

                <p class="p1">${usermsg.getMessage()}</p>
            </c:if>
        </c:forEach>
    </div>


        <input name="usermsg" type="text" id="usermsg" size="63" />
        <input name="submitmsg" type="submit"   value="submitmsg" />

</div>
</form>
</body>
</html>