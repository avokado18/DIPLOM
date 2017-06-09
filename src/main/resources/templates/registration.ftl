<#include "/parts/header.ftl">

<div class="page-header" style="color: #1b6d85" align="center" >
    <h1><strong><b>Регистрация</b></strong> </h1>
</div>

<div class="row">
    <div class="col-md-7 col-md-offset-3">
    <h4><br><strong><p style="color: red">${error!}</p></strong></h4>
        <form name="user" role="form" action="/registration" method="post" class="form-horizontal">
            <label for="username">Введите логин: </label>
            <input id="username" type="text" class="form-control" name="username" required="true"/>
            <br>
            <label for="password">Введите пароль: </label>
            <input id="password" type="password" class="form-control" name="password" required="true"/>
            <br>
            <button type="submit" class="btn btn-success small" id="submit">Зарегистрироваться</button>
        </form>
    </div>
</div>

<#include "/parts/footer.ftl">
