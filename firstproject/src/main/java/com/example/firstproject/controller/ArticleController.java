package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j // logging annotation
public class ArticleController {

    @Autowired // spring boot가 미리 생성해놓은 객체를 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
//        System.out.println(form.toString()); -> replace logging
        log.info(form.toString());

        // 1. DTO를 Entity로 변환
        Article article = form.toEntity();
//        System.out.println(article.toString());
        log.info(article.toString());

        // 2. Repository에게 Enntity를 DB 안에 저장하게 함
        Article saved = articleRepository.save(article);
//        System.out.println(saved.toString());
        log.info(saved.toString());

        return "";
    }

    @GetMapping("articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("i = " + id);

        // 1. id로 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2. 가져온 데이터 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3. 보여줄 페이지 설정
        return "articles/show";
    }
}