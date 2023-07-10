package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;

public class ArticleForm {
    // controller에서 form 데이터를 받을 dto
    // form에서 받을 데이터 명과 일치
    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Article toEntity() {
        return new Article(null, title, content);
    }
}
