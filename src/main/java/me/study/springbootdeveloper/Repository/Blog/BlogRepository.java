package me.study.springbootdeveloper.Repository.Blog;

import me.study.springbootdeveloper.domain.Blog.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
