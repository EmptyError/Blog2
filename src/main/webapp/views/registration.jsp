<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10.05.2017
  Time: 1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/login.css">
</head>
<body>
<form:form action="/registration" method="post" modelAttribute="user">
    <div class="login">
        <div class="input-icon"> <i class="fa fa-user-circle-o icons"> </i>
            <form:errors path="firstName" cssClass="errors"></form:errors>
            <form:input path="firstName" placeholder="First Name" /></div>
        <div class="input-icon">
            <i class="fa fa-address-card icons"> </i>
            <form:errors path="secondName" cssClass="errors"></form:errors>
            <form:input path="secondName" type="text"  placeholder="Second Name" />
        </div>
        <div class="input-icon">
            <i class="fa fa-envelope icons"> </i>
            <form:errors path="email" cssClass="errors"></form:errors>
           <form:input path="email" type="text"  placeholder="Email"/></div>
        <div class="input-icon">
            <i class="fa fa-phone-square icons"> </i>
            <form:errors path="phone" cssClass="errors"></form:errors>
            <form:input path="phone" type="text"  placeholder="Phone"/>
        </div>
        <div class="input-icon">
            <i class="fa fa-user icons"> </i>
            <form:errors path="login" cssClass="errors"></form:errors>
            <form:input path="login" type="text" placeholder="Login"/></div>
        <div class="input-icon">
            <i class="fa fa-unlock-alt icons"> </i>
            <form:errors path="password" cssClass="errors"></form:errors>
            <form:input path="password" type="password"  placeholder="Password"/></div>
        <form:button class="submit"><i class="fa fa-sign-in"></i>Sing Up</form:button>

    </div>
</form:form>

</body>
</html>
