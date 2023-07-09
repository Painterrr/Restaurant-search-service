package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

//    @PostMapping("/articles/create")
//    public String createArticle(@PathVariable Long id) {
//        log.info("id= ", id);
//        return "article/create";
//    }
}
