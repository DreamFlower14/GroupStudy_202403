package me.study.springbootdeveloper.DAO.Blog;

import lombok.Getter;
import me.study.springbootdeveloper.domain.Blog.Article;

@Getter
public class ArticleResponse {

    private final String title;
    private final String content;

    public ArticleResponse(Article article) {
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}