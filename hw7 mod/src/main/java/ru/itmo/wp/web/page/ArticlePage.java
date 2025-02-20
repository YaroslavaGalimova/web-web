package ru.itmo.wp.web.page;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.service.ArticleService;

public class ArticlePage extends Page {
    private ArticleService articleService = new ArticleService();
    
    protected void create(HttpServletRequest request, Map<String, Object> view) throws ValidationException {
        User user = getUser();
        if (user == null) {
            throw new ValidationException("You must be logged in to create an article.");
        }

        Article article = new Article();
        article.setTitle(request.getParameter("title"));
        article.setText(request.getParameter("text"));
        article.setUserId(getUser().getId());

        articleService.validate(article);
        articleService.save(article);
    }
}
