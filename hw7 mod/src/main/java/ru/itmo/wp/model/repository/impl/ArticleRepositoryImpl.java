package ru.itmo.wp.model.repository.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.itmo.wp.model.domain.Article;
import ru.itmo.wp.model.domain.Event;
import ru.itmo.wp.model.domain.User;
import ru.itmo.wp.model.exception.RepositoryException;
import ru.itmo.wp.model.repository.ArticleRepository;

public class ArticleRepositoryImpl extends BasicRepositoryImpl implements ArticleRepository {
    
    @Override
    public void save(Article article) {
        getResultSet("INSERT INTO `Article` (`userId`, `title`, `text`, `creationTime`) VALUES (?, ?, ?, NOW())",
        true, List.of(article.getUserId(), article.getTitle(), article.getText()));
    }

    private Article toArticle(ResultSetMetaData metaData, ResultSet resultSet) throws SQLException {
        //System.err.println("meow");
        if (!resultSet.next()) {
            return null;
        }

        Article article = new Article();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            //System.err.println("Column: " + metaData.getColumnName(i) + ", Value: " + resultSet.getString(i));
            switch (metaData.getColumnName(i)) {
                case "id":
                    article.setId(resultSet.getLong(i));
                    break;
                case "userId":
                    article.setUserId(resultSet.getLong(i));
                    break;
                case "title":
                    article.setTitle(resultSet.getString(i));
                    break;
                case "text":
                    article.setText(resultSet.getString(i));
                    break;
                case "creationTime":
                    article.setCreationTime(resultSet.getTimestamp(i));
                    break;
                default:
                    // No operations.
            }
        }
        //System.err.println(article.getTitle());

        return article;
    }

    private Article findArticle(ResultSet resultSet) {
        try {
            Article article =  toArticle(resultSet.getMetaData(), resultSet);
            resultSet.close();
            return article;
        } catch (SQLException e) {
            throw new RepositoryException("Can't find article.", e);
        }
    }

    @Override
    public List<Article> findAll() {
        ResultSet resultSet = getResultSet("SELECT * FROM Article ORDER BY creationTime DESC", false, null);
        Article article;
        ArrayList<Article> articles = new ArrayList<Article>();
        while ((article = findArticle(resultSet)) != null) {
            //System.err.println(article.getTitle());
            articles.add(article);
        }
        return articles;
    }

}
