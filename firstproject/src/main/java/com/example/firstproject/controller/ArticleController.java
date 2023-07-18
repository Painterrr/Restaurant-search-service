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

import java.util.List;

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

        return "redirect:/articles/" + saved.getId();
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

    @GetMapping("/articles")
    public String index(Model model) {
        // 1: Bring all the articles
        // -1: List<Article> articleEmtityList = (List<Article>)articleRepository.findAll();
        // -2: Iterable<Article> articleEmtityList = articleRepository.findAll();
        // -3: in ArtivleRepository, override ArrayList<> findAll()
        List<Article> articleEmtityList = articleRepository.findAll();

        // 2: Pass the bundel of retrieved articles to the view
        model.addAttribute("articleList", articleEmtityList);

        // 3: Set up the view page
        // articles/index.mustache
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Article articleEntity = articleRepository.findById(id).orElse(null);
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form) {
        log.info(form.toString());
        // 1: transform DTO to Entity
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        // 2: save Entity in DB
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);
        if (target != null) {
            articleRepository.save(articleEntity);
        }
        
        // 3: redirect edited contents to detail view page
        return "redirect:/articles/" + articleEntity.getId();
    }
}