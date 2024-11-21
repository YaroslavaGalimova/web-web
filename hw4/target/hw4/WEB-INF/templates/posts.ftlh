<#import "./common.ftlh" as c>

<@c.page>
<link rel="stylesheet" href="/css/index.css">
    <#list posts as post>
        <#if user_id == post.user_id>
            <@c.one_post post users post.text/>
        </#if>
    </#list>
</@c.page> 