<#macro page>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Codeforces</title>
        <link rel="stylesheet" href="/css/normalize.css">
        <link rel="stylesheet" href="/css/style.css">
        <link rel="icon" href="/favicon.ico">
    </head>
    <body>
    <@header/>
    <div class="middle">
        <@sidebar/>
        <main>
            <#nested/>
        </main>
    </div>
    <@footer/>
    </body>
    </html>
</#macro>

<#macro header>
    <header>
        <a href="#" class="logo"><img alt="Codeforces" title="Codeforces"
                                      src="/img/codeforces-logo-with-telegram.png"></a>
        <div class="languages">
            <a href="#"><img alt="In English" title="In English"
                             src="/img/gb.png"></a>
            <a href="#"><img alt="In Russian" title="In Russian"
                             src="/img/ru.png"></a>
        </div>
        <div class="enter-or-register-box">
            <#if user??>
                <@userlink user "false"/>
                |
                <a href="/logout">Logout</a>
            <#else>
                <a href="/enter">Enter</a>
                |
                <a href="/register">Register</a>
            </#if>
        </div>
        <nav>
            <#assign items=[
            {"href": "/index", "name": "Home"},
            {"href": "/misc/help", "name": "Help"},
            {"href": "/contests", "name": "Contests"},
            {"href": "/users", "name": "Users"}
            ]/>
            <ul>
                <#list items as item>
                    <li>
                    <#if uri == item.href>
                        <a id="underlined" href="${item.href}">${item.name}</a>
                    <#else>
                        <a href="${item.href}">${item.name}</a>
                    </#if>
                    </li>
                </#list>
            </ul>
        </nav>
    </header>
</#macro>

<#macro sidebar>
    <aside>
        <#list posts?reverse as post>
            <section>
                <div class="header">Post #${post.id}</div>
                <div class="body">
                    ${c.short_text(post.text, 350)}
                </div>
                <div class="footer">
                    <a href="/post?post_id=${post.id}">View all</a>
                </div>
            </section>
        </#list>
    </aside>
</#macro>

<#macro footer>
    <footer>
        2010-2021 &copy; by Mike Mirzayanov and Yaroslava Galimova (чуть-чуть)
    </footer>
</#macro>

<#macro userlink user nameOnly>
<#-- @ftlvariable name="user" type="ru.itmo.web.hw4.model.User" -->
    <#if nameOnly == "true">
        <a href="/user?handle=${user.handle}" class="userlink ${user.color}">${user.name}</a>
    <#else>
        <a href="/user?handle=${user.handle}">${user.name}</a>
    </#if>
</#macro>

<#macro one_post post users post_text>
    <article>
        <div class="title">${post.title}</div>
        <div class="information">By ${c.findBy(users, "id", post.user_id).name}, 2 days ago</div>
        <div class="body">
            ${post_text}
        </div>
        <div class="footer">
            <div class="left">
                <img src="img/voteup.png" title="Vote Up" alt="Vote Up"/>
                <span class="positive-score">+173</span>
                <img src="img/votedown.png" title="Vote Down" alt="Vote Down"/>
            </div>
            <div class="right">
                <img src="img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                some days ago
                <img src="img/comments_16x16.png" title="Comments" alt="Comments"/>
                <a href="#">68</a>
            </div>
        </div>
    </article>
</#macro>

<#macro news post users>
    <@one_post post users c.short_text(post.text, 350)/>
</#macro>



<#function findBy items key value>
    <#list items as item>
        <#if item[key] == value>
            <#return item/>
        </#if>
    </#list>
</#function>

<#function findNext items key value>
    <#list items as item>
        <#if pr?? && pr[key] == value>
            <#return item/>
        </#if>
        <#assign pr = item/>
    </#list>
</#function>

<#function findPrev items key value>
    <#list items as item>
        <#if pr?? && item[key] == value>
            <#return pr/>
        </#if>
        <#assign pr = item/>
    </#list>
</#function>

<#function short_text text size>
    <#if text?length &gt; size>
        <#return text[0..size] + "..."/>
    <#else>
        <#return text>
    </#if>
</#function>


