package ru.itmo.wp.model.repository;

import java.util.List;

import ru.itmo.wp.model.domain.Article;

public interface ArticleRepository {
    
    void save(Article article);

    List<Article> findAll();
}
