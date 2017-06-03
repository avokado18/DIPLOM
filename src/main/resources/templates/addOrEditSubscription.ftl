<#include "/parts/header.ftl">

<script>
    window.onload = function(){
        document.getElementById("id").value = document.getElementById("id").value.split(String.fromCharCode(160)).join("");
    }
</script>

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <form name="subscription" role="form" action="/subscriptions/save" method="post" class="form-horizontal">
            <input id="id" type="hidden" class="form-control" name="id" value="${subscription.id!}"/>
            <label for="tag">Введите тэг: </label>
            <input id="tag" type="text" class="form-control" name="tag" required="true" value="${subscription.tag!}"/>
            <br>
            <label for="email">Введите email: </label>
            <input id="email" type="text" class="form-control" name="email" required="true" value="${subscription.email!}"/>
            <br>
            <button type="submit" class="btn btn-primary btn-lg small" id="submit">Сохранить</button>
        </form>
        <br>
        <br>
        <a class="button" href="/">На главную</a>
    </div>
</div>

<#include "/parts/footer.ftl">
