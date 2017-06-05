<#include "/parts/header.ftl">

<div class="row">
    <div class="col-md-6 col-md-offset-3">
    ${error!}
        <form name="user" role="form" action="/registration" method="post" class="form-horizontal">
            <label for="username">Введите логин: </label>
            <input id="username" type="text" class="form-control" name="username" required="true"/>
            <br>
            <label for="password">Введите пароль: </label>
            <input id="password" type="password" class="form-control" name="password" required="true"/>
            <br>
            <button type="submit" class="btn btn-primary btn-lg small" id="submit">Зарегистрироваться</button>
        </form>
    </div>
</div>

</div>
</body>
</html>
