<#include "/parts/header.ftl">

<div class="page-header" style="color: #1b6d85" align="center" >
    <h1><strong><b>Список ваших подписок, ${user.username}</b></strong> </h1>
</div>

<label class="logoutLblPos">
<#include "/parts/logout.ftl">
</label>

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <table class="table table-striped">
            <tr>
                <th>Tag</th>
                <th>Email</th>
                <th>Edit</th>
            </tr>
            <#list subscriptions as subscription>
                <tr>
                    <td class="editable-td subscription-tag">${subscription.tag!}</td>
                    <td class="editable-td subscription-email">${subscription.email!}</td>
                    <td>
                        <a class="btn btn-warning small" href="subscriptions/edit/${subscription.id}"> Изменить </a>
                        <a class="btn btn-danger small" href="subscriptions/delete/${subscription.id}"> Удалить </a>
                    </td>
                </tr>
            </#list>
        </table>
        <a class="btn btn-primary small" href="subscriptions/add">Добавить подписку</a>
    </div>
</div>