<#import "commons.ftlh" as c>

<@c.page>
    <div class="add-notice form-box">
        <div class="header">Add notice</div>
        <div class="body">
            <form method="post" action="">
                <div class="field">
                    <div class="name">
                        <label for="content">Content</label>
                    </div>
                    <div class="value">
                        <textarea id="content" name="content" value="${notice.content!}"></textarea>
                    </div>
                    <@c.error "notice.content"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Add notice">
                </div>
            </form>
        </div>
    </div>
</@c.page>
