package me.study.springbootdeveloper.DAO.Blog;

import lombok.Getter;
import me.study.springbootdeveloper.domain.Blog.Article;

@Getter
public class ArticleListViewResponse {
    private final Long id;
    private final String title;
    private final String content;

    public ArticleListViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
