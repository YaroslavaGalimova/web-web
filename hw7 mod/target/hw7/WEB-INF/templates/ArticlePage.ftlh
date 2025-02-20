<#-- @ftlvariable name="login" type="java.lang.String" -->
<#-- @ftlvariable name="password" type="java.lang.String" -->
<#-- @ftlvariable name="error" type="java.lang.String" -->
<#import "commons.ftlh" as c>

<@c.page>
    <div class="form-box">
        <div class="header">Article</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="create"/>
                <div class="field">
                    <div class="title">
                        <label for="title">Title</label>
                    </div>
                    <div class="value">
                        <input id="title" name="title"/>
                    </div>
                </div>
                <div class="field">
                    <div class="text">
                        <label for="text">Text</label>
                    </div>
                    <div class="value">
                        <textarea id="text" name="text"></textarea>
                    </div>
                </div>
                <div class="error"></div>
                <div class="button-field">
                    <input type="submit" value="Create">
                </div>
            </form>
        </div>
    </div>

    <script>
        $(function () {
            $(".form-box form").submit(function () {
                const $title = $(this).find("input[name=title]");
                const $text = $(this).find("textarea[name=text]");
                const $error = $(this).find(".error");

                super_puper_ajax(
                    {
                        action: "create",
                        title: $title.val(),
                        text: $text.val()
                    }, 
                    function (response) {
                        if (response["error"]) {
                            $error.text(response["error"]);
                            return;
                        }
                        notify("Article saved!");
                        $title.val("");
                        $text.val("");
                    }
                );
                return false;
            });
        })
    </script>

</@c.page>
