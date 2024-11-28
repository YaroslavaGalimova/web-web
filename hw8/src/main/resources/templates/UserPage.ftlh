<#import "commons.ftlh" as c>
<#import "spring.ftl" as spring>

<@c.page>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/css/user.css'/>">
    <#if found_user?has_content>
        <div class="profile">
            <div class="login">${found_user.login}</div>
            <div class="id">id: ${found_user.id}</div>
            <div class="creationTime">${found_user.creationTime}</div>
        </div>
    <#else>
        <div class="no_such_user">
            No such user 
            <img src="<@spring.url '/img/no_such_user.png'/>" alt="Тут милая картинка с котиком" title="Мяу мяу мяу" />
        </div>
    </#if>
</@c.page>
