<#include "/parts/header.ftl">
<h2>Hi, USER, this is the list of your subscriptions</h2>

<script>
    function idWithoutSpaces(id) {
        id.replace(' ', '');
    }
</script>
<table class="table table-striped">
    <tr>
        <th>id</th>
        <th>Tag</th>
        <th>Email</th>
        <th>Edit</th>
    </tr>

<#list subscriptions as subscription>
    <tr>
        <td class="editable-td subscription-id">${subscription.id!}</td>
        <td class="editable-td subscription-tag">${subscription.tag!}</td>
        <td class="editable-td subscription-email">${subscription.email!}</td>
        <td><a class="button" href="subscriptions/edit/${subscription.id}"> Изменить </a>
        <a class="button" href="subscriptions/delete/${subscription.id}"> Удалить </a> </td>
    </tr>
</#list>
</table>

<a class="button" href="subscriptions/add">Добавить подписку</a>

<#include "/parts/footer.ftl">