package com.example.firstproject.dto;

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
}
