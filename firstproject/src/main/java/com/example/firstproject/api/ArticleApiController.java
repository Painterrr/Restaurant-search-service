package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ArticleApiController {
//    @Autowired // DI
//    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;


//    // GET all
//    @GetMapping("/api/articles")
//    public List<Article> index() {
//        return articleRepository.findAll();
//    }
    // GET all
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleService.index();
    }

//    GET one
//    @GetMapping("/api/articles/{id}")
//    public Article show(@PathVariable Long id) {
//        return articleRepository.findById(id).orElse(null);
//    }
    // GET one
    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

//    // POST
//    @PostMapping("/api/articles")
//    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
//        log.info(dto.toString());
//        Article created = articleRepository.save(dto.toEntity());
//        return ResponseEntity.status(HttpStatus.CREATED).body(created);
//    }
    // POST
    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

//    // PATCH
//    @PatchMapping("/api/articles/{id}")
//    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
//
//        // 1. create updating Entity
//        Article article = dto.toEntity();
//        log.info("id: {}, article: {}", id, article.toString());
//
//        // 2. select target Entity
//        Article target = articleRepository.findById(id).orElse(null);
//
//        // 3. deal Bad Request(there is no target or different id)
//        if (target == null || id != article.getId()) {
//            // 400. Response "BAD Request"
//            log.info("BAD Request! id: {}, article: {}", id, article.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        // 4. update and response
//        target.patch(article);
//        Article updated = articleRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
    // PATCH
    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        Article updated = articleService.update(id, dto);
        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

//    // DELETE
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable Long id) {
//        // 1. find target
//        Article target = articleRepository.findById(id).orElse(null);
//
//        // 1-1. deal BAD Request
//        if (target == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        // 2. delete target
//        articleRepository.delete(target);
//
//        // 3. return data
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}