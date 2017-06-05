<#include "/parts/header.ftl">


<div class="row">
    <div class="col-md-6 col-md-offset-3">
        ${message!}
        <form role="form" name="user" action="/login" method="post" class="form-horizontal">
            <label for="username" style="font-weight: 700;">Логин</label>
            <input type="text" name="username" class="form-control"/>
            <br>
            <label for="password" style="font-weight: 700;">Пароль</label>
            <input type="password" name="password" class="form-control"/>
            <br>
            <button type="submit" class="btn btn-primary btn-lg small" id="submit">Войти</button>
            <br>
            <br>
            <a href="/registration">Зарегистрироваться</a>
        </form>
    </div>
</div>
<br>
<br>

</div>
</body>
</html>