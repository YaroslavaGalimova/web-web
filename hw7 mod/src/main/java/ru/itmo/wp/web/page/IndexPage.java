package ru.itmo.wp.web.page;

import com.google.common.base.Strings;

import ru.itmo.wp.model.service.ArticleService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SuppressWarnings({"unused"})
public class IndexPage extends Page {
    private final ArticleService articleService = new ArticleService();
    private void findAll(HttpServletRequest request, Map<String, Object> view){
        view.put("articles", articleService.findAll());
        view.put("users", userService.findAll());
    }
}
