package ru.itmo.wp.model.service;

import java.util.List;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.exception.ValidationException;
import ru.itmo.wp.model.repository.ArticleRepository;
import ru.itmo.wp.model.repository.impl.ArticleRepositoryImpl;

public class ArticleService {
    private final ArticleRepository articleRepository = new ArticleRepositoryImpl();

    public void save(Article article) {
        articleRepository.save(article);
    }

    public void validate(Article article) throws ValidationException {
        if (article.getTitle() == null || article.getTitle().isEmpty() || article.getTitle().isBlank()) {
            throw new ValidationException("Title is required");
        }
        if (article.getTitle().length() > 255) {
            throw new ValidationException("Title can't be longer than 255 characters");
        }
        if (article.getText() == null || article.getText().isEmpty() || article.getText().isBlank()) {
            throw new ValidationException("Text is required");
        }
        if (article.getText().length() > (1<<24)) {
            throw new ValidationException("Text can't be soooo long");
        }
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }
}
