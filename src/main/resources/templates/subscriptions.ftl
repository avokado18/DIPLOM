<#include "/parts/header.ftl">
<h2>Hi, ${user.username}, this is the list of your subscriptions</h2>

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
        <td><a class="button" href="subscriptions/edit/${subscription.id}"> Изменить </a>
        <a class="button" href="subscriptions/delete/${subscription.id}"> Удалить </a> </td>
    </tr>
</#list>
</table>

<a class="button" href="subscriptions/add">Добавить подписку</a>

<#include "/parts/footer.ftl">