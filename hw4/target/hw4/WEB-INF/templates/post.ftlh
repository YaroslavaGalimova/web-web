<#import "./common.ftlh" as c>

<@c.page>
<link rel="stylesheet" href="/css/index.css">
     <#if post_id?has_content> 
          <#assign post = c.findBy(posts, "id", post_id)!/>
     </#if>
     <#if post?has_content>
          <@c.one_post post users post.text/>
     <#else> 
          No such post
     </#if>
</@c.page>