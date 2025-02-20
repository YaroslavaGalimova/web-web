<#import "commons.ftlh" as c>

<@c.page>
    <template class="indexArticle">
        <article>
            <div class="title"></div>
            <div class="information"></div>
            <div class="body"></div>

            <div class="footer">
                <div class="left">
                    <img src="img/voteup.png" title="Vote Up" alt="Vote Up"/>
                    <span class="positive-score">+173</span>
                    <img src="img/votedown.png" title="Vote Down" alt="Vote Down"/>
                </div>
                <div class="right">
                    <img src="img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                    2 days ago
                    <img src="img/comments_16x16.png" title="Comments" alt="Comments"/>
                    <a href="#">68</a>
                </div>
            </div>
        </article>
    </template>


    <script>
        $(function() {
            super_puper_ajax(
                {action: "findAll"},
                function(response) {
                    response["articles"].forEach(function(article) {
                        const $article = $($("template.indexArticle").prop("content")).clone();
                        $article.find(".title").text(article.title);
                        $article.find(".body").text(article.text);
                        $article.find(".information").text(article.creationTime);
                        $("main").append($article);
                    });
                }
            );
        })
    </script>
</@c.page>
