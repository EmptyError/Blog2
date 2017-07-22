<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.05.2017
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/login.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="/resources/css/home.css">
</head>
<body>
<div class="side-bar">
    <div class="menu-avatar a-whiteColor-side-bar text-side-bar"><a  href="/add/photo/"><img class="img-avatar" src="/resources/img/${user.pathToPhoto}" alt="avatar">  </a>${user.login} </div>

    <div class="menu-home a-whiteColor-side-bar text-side-bar"> <a  class="a-whiteColor-side-bar text-side-bar" href="/"><i class="fa fa-home icons-side-bar"> </i>  </a>Home</div>
    <div class="menu a-whiteColor-side-bar text-side-bar"> <a  class="a-whiteColor-side-bar text-side-bar" href="/incomes"><i class="fa fa-plus icons-side-bar"> </i> </a>Incomes</div>
    <div class="menu a-whiteColor-side-bar text-side-bar"><a  class="a-whiteColor-side-bar text-side-bar" href="/spending"><i class="fa fa-minus icons-side-bar"> </i>  </a>Spendings</div>
    <div class="menu a-whiteColor-side-bar text-side-bar"><a  class="a-whiteColor-side-bar text-side-bar" href="/logout"><i class="fa fa-sign-out icons-side-bar"> </i>  </a>LogOut</div>
</div>
<c:forEach items="${incomes}" var="income">
<div class="incomes">
<div class="incomes-list">${income.date}:
${income.description} ${income.amount}</div>
</div>
</c:forEach>
<button id="showChart">Show Chart</button>
<div class="chart">
<canvas id="myChart" width="200" height="100"></canvas></div>
<script src="/resources/js/jquery-3.2.1.min.js"></script>
<script src="/resources/js/js.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.bundle.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
<script>

    $("#showChart").on("click", function () {
        $(".chart").slideToggle(100);


        $.ajax({
            url: '/get/incomes/chart',
            method: 'GET',
            contentType: 'application/json',
            success: function (incomes) {
             console.log(incomes);
                var income1 = [];
                var incomeDate=[];
                $.each(incomes, function (i, income) {
                    income1.push(income.amount);
                    incomeDate.push(income.date);
                });
console.log(income1.toString());
                var ctx = document.getElementById('myChart').getContext('2d');
                var chart = new Chart(ctx, {
                    // The type of chart we want to create
                    type: 'line',

                    // The data for our dataset
                    data: {
                        labels: incomeDate,
                        datasets: [{
                            label: "Income",
                            backgroundColor: 'rgba(153,255,51,0.4)',
                            borderColor: 'green',
                            data: income1
                        }
                        ]
                    },

                    // Configuration options go here
                    options: {
                        title: {
                            display: true,
                            text: 'Incomes '
                        }
                    }
                });

            }
        })
    });

//    var ctx = document.getElementById('myChart').getContext('2d');
//    var chart = new Chart(ctx, {
//        // The type of chart we want to create
//        type: 'line',
//
//        // The data for our dataset
//        data: {
//            labels: ["January", "February", "March", "April", "May", "June", "July"],
//            datasets: [{
//                label: "Income",
//                backgroundColor: 'rgba(153,255,51,0.4)',
//                borderColor: 'green',
//                data: [567, 10, 66, 2, 770, 30, 45],
//            },
//                {
//                    label: "Spending",
//                    backgroundColor: 'rgba(255,153,0,0.4)',
//                    borderColor: 'red',
//                    data: [4, 10,75, 2, 20, 3, 455],
//                }
//            ]
//        },
//
//        // Configuration options go here
//        options: {
//            title: {
//                display: true,
//                text: 'Incomes And Spendings'
//            }
//        }
//    });
</script>
</body>
</html>
