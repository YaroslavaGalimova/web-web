<#import "./common.ftlh" as c>

<@c.page>
<link rel="stylesheet" href="/css/index.css">
    <#list posts?reverse as post>
        <@c.news post users/>
    </#list>
</@c.page>
