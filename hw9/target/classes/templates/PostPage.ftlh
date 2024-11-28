<#import "commons.ftlh" as c>
<#import "/spring.ftl" as spring/>

<@c.page>
<link rel="stylesheet" type="text/css" href="<@spring.url '/css/post.css'/>">
    <#if post?has_content>
        <@c.post post/>
        <div class="add-comment form-box">
            <div class="header">Add comment</div>
            <div class="body">
                <form method="post" action="">
                    <div class="field">
                        <div class="name">
                            <label for="text">Text</label>
                        </div>
                        <div class="value">
                            <textarea id="text" name="text" value="${comment.text!}"></textarea>
                        </div>
                        <@c.error "comment.text"/>
                    </div>
                    <div class="button-field">
                        <input type="submit" value="Add comment">
                    </div>
                </form>
            </div>
        </div>
        <#if post.comments?has_content>
            <#list post.comments as comment>
                <div class="comment">
                    <div class="login">${comment.user.login}</div>
                    <div class="text">${comment.text}</div>
                    <div class="ct">${comment.creationTime}</div>
                </div>
            </#list>
        </#if>
    <#else>
        No such post.
    </#if>
</@c.page>

