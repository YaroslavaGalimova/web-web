<#import "/spring.ftl" as spring>

<#macro page>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Codeforces</title>
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/normalize.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/style.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/form.css'/>">
        <link rel="stylesheet" type="text/css" href="<@spring.url '/css/datatable.css'/>">
        <script src="<@spring.url '/js/jquery-3.6.1.min.js'/>"></script>
        <script src="<@spring.url '/js/notify.min.js'/>"></script>
        <script src="<@spring.url '/js/app.js'/>"></script>
    </head>
    <body>
    <header>
        <a href="/"><img src="<@spring.url '/img/logo.png'/>" alt="Codeforces" title="Codeforces"/></a>
        <div class="languages">
            <a href="#"><img src="<@spring.url '/img/gb.png'/>" alt="In English" title="In English"/></a>
            <a href="#"><img src="<@spring.url '/img/ru.png'/>" alt="In Russian" title="In Russian"/></a>
        </div>
        <div class="enter-or-register-box">
            <#if user??>
                ${user.login}
                |
                <a href="<@spring.url '/logout'/>">Logout</a>
            <#else>
                <a href="<@spring.url '/enter'/>">Enter</a>
                |
                <a href="<@spring.url '/register'/>">Register</a>
            </#if>
        </div>
        <nav>
            <ul>
                <li><a href="<@spring.url '/'/>">Home</a></li>
                <li><a href="<@spring.url '/users/all'/>">Users</a></li>
            </ul>
        </nav>
    </header>
    <div class="middle">
        <aside>
            <#if user??>
                <div class="add_notice">
                    <a href="<@spring.url '/addNotice'/>">Add notice</a>
                </div>
            </#if>
            <#if notices??>
                <#--  <div class="header">
                    Pay attention
                </div>  -->
                <#list notices?reverse as notice>
                    <section>
                        <div class="body">
                            ${notice.content}
                        </div>
                        <div class="footer">
                            <a href="<@spring.url '/img/no_href.png'/>">View all</a>
                            <div class="sidebar_notice_id">id: ${notice.id}</div>
                            <div class="sidebar_notice_ct">${notice.creationTime}</div>
                        </div>
                    </section>
                </#list>
            </#if>
        </aside>
        <main>
            <#nested/>
        </main>
    </div>
    <footer>
        <a href="/">Catforces</a> &copy; 2024 by Mike Mirzayanov and ~чуть-чуть~ Yaroslava Galimova
    </footer>
    <script>
        $(function () {
            <#if message??>
                notify("${message?js_string}");
            </#if>
        })
    </script>
    </body>
    </html>
</#macro>

<#macro error field>
    <@spring.bind field/>
    <#if spring.status.errorMessage??>
        <div class="error">${spring.status.errorMessage}</div>
    </#if>
</#macro>