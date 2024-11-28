<#import "commons.ftlh" as c>

<@c.page>
    <div class="users datatable">
        <div class="caption">User</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Created</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <#if users?size==0>
                <tr class="noData">
                    <td colspan="3">
                        No data
                    </td>
                </tr>
            <#else>
                <#list users as user>
                <tr>
                    <td class="id">${user.id}</td>
                    <td class="login">${user.login}</td>
                    <td class="creationTime">${user.creationTime}</td>
                    <td>
                        <form method="post" action="">
                            <input type="hidden" name="userId" value="${user.id}">
                            <input type="hidden" name="status" value="${user.disabled?string('false', 'true')}">
                            <div class="button-field">
                                <#if user.disabled>
                                    <#assign status="Enable"/>
                                <#else>
                                    <#assign status="Disable"/>
                                </#if>
                                <input type="submit" value="${status}">
                            </div>
                        </form>
                    </td>
                </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@c.page>
