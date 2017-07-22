<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.05.2017
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/login.css">
</head>
<body><form action="/loginProcessing" method="post">
<div class="login">

    <div class="input-icon">
        <i class="fa fa-user icons"> </i>
        <input type="text"name="username" placeholder="Login"></div>
    <div class="input-icon">
        <i class="fa fa-unlock-alt icons"> </i>
        <input type="password" name="password" placeholder="Password"></div>
    <button class="submit" type="submit"><i class="fa fa-sign-in"></i>Sing In</button>
    <div class="white-color">No profile? <a class="a-whiteColor" href="/registration">Register</a></div>

</div>
</form>
</body>
</html>
