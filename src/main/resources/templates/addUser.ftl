<#include "/parts/header.ftl">

<script>
    window.onload = function(){
        document.getElementById("id").value = document.getElementById("id").value.split(String.fromCharCode(160)).join("");
    }
</script>

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <form name="user" role="form" action="/users/save" method="post" class="form-horizontal">
            <input id="id" type="hidden" class="form-control" name="id" value="${user.id!}"/>
            <label for="username">Введите тэг: </label>
            <input id="username" type="text" class="form-control" name="tag" required="true" value="${user.username!}"/>
            <br>
            <label for="password">Введите email: </label>
            <input id="password" type="text" class="form-control" name="email" required="true" value="${user.password!}"/>
            <br>
            <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary btn-lg small" id="submit">Сохранить</button>
        </form>
        <br>
        <br>
        <a class="button" href="/">На главную</a>
    </div>
</div>

<#include "/parts/footer.ftl">
