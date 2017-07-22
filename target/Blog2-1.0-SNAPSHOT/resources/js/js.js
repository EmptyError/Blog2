/**
 * Created by Admin on 12.05.2017.
 */
function showIcons() {
    $(".add-category").hide();
$(".add-account").slideToggle(100);


}

var iconClass='';
var iconClass1='';
function saveIcon(obj) {

     var icon=$(obj).attr('class');
     var iconClass=icon.split(' ');
    iconClass1=iconClass[1];
    console.log(iconClass1);


}
function  getObject() {
return [$("#accountName").val(),$("#balance").val(),iconClass1,$("#select-currency").val()]

}
// {name:$("#accountName").val(),amount:$("#balance").val(),icon:iconClass1}



$("#add-account").mousedown(function () {

    $.ajax({
        url:'/account/add/',
        method:'POST',
        contentType:'application/json',
        data: JSON.stringify(getObject()),
        success:function () {
// $(".add-account").hide();

        }

    })
});

function getObjectCategory() {
    return[$("#category-name").val(),iconClass1]

}
$("#add-category").mousedown(function () {

    $.ajax({
        url:'/category/add/',
        method:'POST',
        contentType:'application/json',
        data: JSON.stringify(getObjectCategory()),
        success:function () {
$(".add-category").hide();

        }

    })
});

$("#add-category").mouseup("click", function () {


    $.ajax({
        url:'/category/find/all',
        method:'GET',
        contentType:'application/json',
        success: function (categories) {
            console.log(categories[categories.length-1]);



            console.log(categories[categories.length-1]);

            // html="<div class='balance'><div class='icon-active '><a  class='text' ><i class='fa " +accounts[accounts.length-1].icon+" ' icon-add-category'> </i>  </a></div>"+accounts[accounts.length-1].name+"</div>"

            // $("#icons").append("<div class='balance'><div class='icon-active'></div><a  class='text' > <i class='fa "+accounts[accounts.length-1].icon+" icon-add-category'> </i></a></div>");
            $("#icons-category").append( "<div class='balance'><div class='icon-category'><a class='text' ><i class='fa "+categories[categories.length-1].icon+ " icon-add-category'> </i>  </a></div><div>"+categories[categories.length-1].name+":"+"0"+"</div></div>");

            $(".add-category").slideUp(200)
        }
    })
});


$("#add-account").mouseup("click", function () {


    $.ajax({
        url:'/account/find/all',
        method:'GET',
        contentType:'application/json',
        success: function (accounts) {
            console.log(accounts[accounts.length-1]);


            var lastAccount=accounts[accounts.length-1];
console.log(accounts[arguments.length-1]);

            // html="<div class='balance'><div class='icon-active '><a  class='text' ><i class='fa " +accounts[accounts.length-1].icon+" ' icon-add-category'> </i>  </a></div>"+accounts[accounts.length-1].name+"</div>"

            // $("#icons").append("<div class='balance'><div class='icon-active'></div><a  class='text' > <i class='fa "+accounts[accounts.length-1].icon+" icon-add-category'> </i></a></div>");
            $("#icons").append( "<div class='balance'><div class='icon-active'><a class='text' href='/'><i class='fa "+accounts[accounts.length-1].icon+ " icon-add-category'> </i>  </a></div><div>"+accounts[accounts.length-1].name+":"+accounts[accounts.length-1].amount+"</div></div>");

            $(".add-account").slideUp(500)
        }
    })
});

function showIconsSpending() {
    $(".add-account").hide();
    $(".add-category").slideToggle(200);


}