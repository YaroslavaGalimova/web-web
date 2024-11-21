<#import "./common.ftlh" as c>

<@c.page>
<link rel="stylesheet" href="/css/users.css">
    <div class="datatable">
        <div class="caption">USERS</div>
            <table>
                <tbody>
                    <#list users as u>
                        <tr>
                            <#if user?? && user.id == u.id>*</#if>
                             <td> <@c.userlink u "true"/> </td>
                        </tr>
                    </#list>
                </tbody>
            </table>
        </div>
</@c.page>