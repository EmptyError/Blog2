<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19.05.2017
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="/resources/css/login.css">
    <link rel="stylesheet" href="/resources/css/addIncome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/home.css">
    <title>Title</title>
</head>
<body>
<div class="side-bar">
    <div class="menu a-whiteColor-side-bar text-side-bar"> <a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-user icons-side-bar"> </i></a>${user.login}</div>
    <div class=" menu a-whiteColor-side-bar text-side-bar"> <a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-home icons-side-bar"> </i>  </a>Home</div>
    <div class="menu-home  a-whiteColor-side-bar text-side-bar"> <a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-plus icons-side-bar"> </i> </a>Incomes</div>
    <div class="menu a-whiteColor-side-bar text-side-bar"><a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-minus icons-side-bar"> </i>  </a>Spendings</div>
    <div class="menu a-whiteColor-side-bar text-side-bar"><a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-sign-out icons-side-bar"> </i>  </a>LogOut</div>
</div>
<div class="login">
    <form method="post" action="/add/spending/${category.id}">
        <p style="color: white;text-align: center">${category.name}</p>
        <input class="add-income" type="text" name="description" placeholder="Description">
        <input class="add-income" type=text name="amount" placeholder="0.0" >
        <input class="add-income" type="date" name="date">
        <span>From what account?</span> <select name="account" >
        <c:forEach items="${accounts}" var="account">
        <option value="${account.id}">${account.name}:${account.amount}</option>
        </c:forEach>
    </select>
        <button class="submit" type="submit">Add</button>
    </form>
</div>

</body>
</html>
