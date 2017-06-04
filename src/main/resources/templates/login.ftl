<#include "/parts/header.ftl">
<form role="form" name="user" action="/login" method="post" class="form-horizontal">
    <div>
        <label for="username" style="font-weight: 700;">Логин</label>
        <input type="text" name="username" class="form-control"/>
    </div>
    <div>
        <label for="password" style="font-weight: 700;">Пароль</label>
        <input type="password" name="password" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-primary btn-lg small" id="submit">log in</button>
</form>

</div>
</body>
</html>