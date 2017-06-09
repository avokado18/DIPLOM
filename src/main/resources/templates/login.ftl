<#include "/parts/header.ftl">

<div class="page-header" style="color: #1b6d85" align="center" >
    <h1><strong><b>Добро пожаловать</b></strong> </h1>
</div>

<div class="row">
    <div class="col-md-7 col-md-offset-3">
        <h4><br><strong><p style="color: blue">${message!}</p></strong></h4>
        <form role="form" name="user" action="/login" method="post" class="form-horizontal">
            <label for="username" style="font-weight: 700;">Логин</label>
            <input type="text" name="username" class="form-control"/>
            <br>
            <label for="password" style="font-weight: 700;">Пароль</label>
            <input type="password" name="password" class="form-control"/>
            <br>
            <button type="submit" class="btn btn-primary small" id="submit">Войти</button>
            <a href="/registration" class="btn btn-default small">Зарегистрироваться</a>
            <br>
            <br>
        </form>
    </div>
</div>

<#include "/parts/footer.ftl">