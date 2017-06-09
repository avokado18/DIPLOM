<#include "/parts/header.ftl">


<div class="page-header" style="color: #1b6d85" align="center" >
    <h1><strong><b>Сохраните подписку</b></strong> </h1>
</div>

<label class="logoutLblPos">
    <#include "/parts/logout.ftl">
</label>

<script>
    window.onload = function(){
        document.getElementById("id").value = document.getElementById("id").value.split(String.fromCharCode(160)).join("");
    }

    function validateEmail() {
        var email = document.getElementById("email").value;
        var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!re.test(email)){
            document.getElementById("email").style.backgroundColor = "red";
            return false;
        }
        return true;
    }

    function emailClick() {
        document.getElementById("email").style.backgroundColor = "white";
    }
</script>

<div class="row">
    <div class="col-md-7 col-md-offset-3">
        <form name="subscription" role="form" action="/subscriptions/save" method="post" class="form-horizontal">
            <input id="id" type="hidden" class="form-control" name="id" value="${subscription.id!}"/>
            <label for="tag">Введите тэг: </label>
            <input id="tag" type="text" class="form-control" name="tag" required="true" value="${subscription.tag!}"/>
            <br>
            <label for="email">Введите email: </label>
            <input id="email" type="text" class="form-control" name="email" required="true" value="${subscription.email!}"  onclick="emailClick()"/>
            <br>
            <button type="submit" class="btn btn-primary small" id="submit" onclick="return validateEmail()">Сохранить</button>
        </form>
        <br>
        <br>
    </div>
</div>

<#include "/parts/footer.ftl">
