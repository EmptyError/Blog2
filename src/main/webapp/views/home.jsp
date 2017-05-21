<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.05.2017
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/resources/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="/resources/css/home.css">
</head>
<body>
<div class="side-bar">
<div class="menu-avatar a-whiteColor-side-bar text-side-bar"><img class="img-avatar" src="/resources/img/${user.pathToPhoto}" alt="avatar"> <a  class=" addPhoto" href="/add/photo/">Add Photo </a>${user.login} </div>

<div class="menu-home a-whiteColor-side-bar text-side-bar"> <a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-home icons-side-bar"> </i>  </a>Home</div>
<div class="menu a-whiteColor-side-bar text-side-bar"> <a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-plus icons-side-bar"> </i> </a>Incomes</div>
<div class="menu a-whiteColor-side-bar text-side-bar"><a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-minus icons-side-bar"> </i>  </a>Spendings</div>
<div class="menu a-whiteColor-side-bar text-side-bar"><a  class="a-whiteColor-side-bar text-side-bar" href="/logout"><i class="fa fa-sign-out icons-side-bar"> </i>  </a>LogOut</div>
</div>
<div class="right">
<div id="balance-all" >Balance:</div>
<div id="spending">Spending: ${sumSpending}</div>
<div id="income">Income: ${sumIncomes}</div>


<div id="icons">

<c:forEach items="${accounts}" var="account">
    <div class="balance"><div  class="icon-active "><a  class="text" ><i class="fa ${account.icon} icon-add-category"> </i>  </a>

    </div><div id="ammount-name">${account.name}:${account.amount}

    </div><div class="dropdawn">
        <a class="a-menu" href="/add/income/${account.id}">Add Income</a><br>
        <a class="a-menu" href="/add/spending/${account.id}">Add Spending</a><br>
        <a class="a-menu" href="/delete/account/${account.id}">Delete Account</a>


    </div></div>

</c:forEach>
</div>
<div class="balance"><div class="icon"><i onclick="showIcons()" class="fa fa-plus icon-add-category"> </i>  </div></div>
    <div class="add-account">
        <input id="accountName" class="input-center" placeholder=" Account Name" name="accountName">
        <input id="balance" class="input-center" placeholder="balance" name="balance">
        <p class="text-center">Currency:
            <select id="select-currency">
                <c:forEach items="${currencyList}" var="currency">
                    <option value="${currency.id}">${currency.symbol}</option>
                </c:forEach>
            </select>
            <a id="add-currency" class="text-center" >Add Currency</a>
        </p>

        <p class="text-center">Choose icon for your category:</p>
        <div class="icon-choose id" id="icon-choose-first"> <i onclick="saveIcon(this)" class="fa fa-university icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-money icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-credit-card icon-add-category"> </i></div>
        <button id="add-account">Add</button>
    </div>
<hr>
    <div class="add-category">
        <input id="category-name" class="input-center" placeholder="Category Name" name="categoryName">
        <p class="text-center">Choose icon for your account:</p>
        <div class="icon-choose " > <i onclick="saveIcon(this)" class="fa fa-home icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-glass icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-ambulance icon-add-category"> </i></div>
        <div class="icon-choose " > <i onclick="saveIcon(this)" class="fa fa-subway icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-car icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-internet-explorer icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-shopping-bag icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-coffee icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-gift icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-bed  icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-globe icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-shopping-cart  icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-bed  icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-globe icon-add-category"> </i></div>
        <div  class="icon-choose"> <i onclick="saveIcon(this)" class="fa fa-shopping-cart  icon-add-category"> </i></div>
        <button id="add-category">Add</button>
    </div>
<div id="icons-category">

    <c:forEach items="${categories}" var="category">

    <div class="balance"><div  class="icon-category "><a  class="text" ><i class="fa ${category.icon} icon-add-category"> </i>  </a>

    </div><div id="category-balance-name">${category.name}:${category.amount}
        <div class="dropdawn-categories">
            <a class="a-menu" href="/add/spending/${category.id}">Add Spending</a><br>

            <a class="a-menu" href="/delete/category/${category.id}">Delete Category</a>
        </div>
    </div></div>

    </c:forEach>

</div>
<div class="balance"><div class="icon"><i onclick="showIconsSpending()" class="fa fa-plus icon-add-category"> </i>  </div></div>


</div>
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/js.js"></script>
</body>
</html>
