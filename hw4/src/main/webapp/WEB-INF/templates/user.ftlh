<#-- @ftlvariable name="handle" type="java.lang.String" -->
<#import "./common.ftlh" as c>

<@c.page>
<link rel="stylesheet" href="/css/user.css">
    <#if handle??>
        <#assign u = c.findBy(users, "handle", handle)!/>
    <#else>
        <#if user_id?has_content>
            <#assign u = c.findBy(users, "id", user_id)!/>
        </#if>
    </#if>

    <div class="user_table">
        <#if u?has_content>
            <div class="user_data">
                <div class="name_link"> <@c.userlink u "true"/> </div>
                <ul>
                    <li>id: ${u.id}</li>
                    <li>handle: ${u.handle}</li>
                    <li>name: ${u.name}</li>
                    <li><a href = "/posts?user_id=${u.id}">posts: ${u.postsCount}</a></li>
                </ul>
            </div>
            <img src="../../img/default-photo.jpeg" alt="no photo"/>
        <#else>
            No such user
        </#if>
    </div> 

    <#if u?has_content>
        <#assign prev = c.findPrev(users, "id", u.id)!/>
        <#if prev?has_content>
            <a class="arrow_link" href="/user?handle=${prev.handle}">←</a>
        <#else>
            <span>←</span>
        </#if>

        <#assign next = c.findNext(users, "id", u.id)!/>
        <#if next?has_content>
            <a class="arrow_link" href="/user?handle=${next.handle}">→</a>
        <#else>
            <span>→</span> 
        </#if>
    </#if>

</@c.page>
