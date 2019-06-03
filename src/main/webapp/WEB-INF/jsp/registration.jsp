<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="container">

    <form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <div class="form-signin-heading ${error != null ? 'has-error' : ''}">
            <input name="firstname" type="text" class="form-signin-heading" placeholder="Firstname"
                   autofocus="true"/>

            <input name="lastname" type="text" class="form-signin-heading" placeholder="Lastname"
                   autofocus="true"/>
            <input name="username1" type="text" class="form-signin-heading" placeholder="Username"
                   autofocus="true"/>
            <input name="password1" type="password" class="form-signin-heading" placeholder="Password"/>


</div>
        <span>${error}</span>
        <input class="btn btn-lg btn-primary btn-block" name="Submit" type="submit" value="Submit" />
    </form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>