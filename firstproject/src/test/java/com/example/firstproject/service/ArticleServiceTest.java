package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // The test is performed in conjunction with Spring Boot
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        // expected
        Article a = new Article(1L, "dummy1", "1111");
        Article b = new Article(2L, "dummy2", "2222");
        Article c = new Article(3L, "dummy3", "3333");
        Article d = new Article(4L, "title1", "content1");
        Article e = new Article(5L, "title2", "content2");
        Article f = new Article(6L, "title3", "content3");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c, d, e, f));

        // actual
        List<Article> actual = articleService.index();

        // comparison
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void show_success_sameId() {
        // expected
        Long id = 1L;
        Article expected = new Article(id, "dummy1", "1111");

        // actual
        Article actual = articleService.show(id);

        // comparison
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void show_fail_differentId() {
        // expected
        Long id = -1L;
        Article expected = null;

        // actual
        Article actual = articleService.show(id);

        // comparison
        assertEquals(expected, actual);
    }

    @Test
    @Transactional
    void create_success_input_title_content() {
        // expected
        String title = "dummy4";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(7L, title, content);

        // actual
        Article actual = articleService.create(dto);

        // comparison
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @Transactional
    void create_fail_input_wrong_id() {
        // expected
        Long id = 4L;
        String title = "dummy4";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        // actual
        Article actual = articleService.create(dto);

        // comparison
        assertEquals(expected, actual);
    }

    @Test
    @Transactional
    void update_success_id_title_content() {
        // expected
        Long id = 1L;
        String title = "changedTitle1";
        String content = "changedContent1";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);

        // actual
        Article actual = articleService.update(id, dto);

        // comparison
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @Transactional
    void update_success_id_content() {
        // expected
        Long id = 1L;
        String content = "changedContent1";
        ArticleForm dto = new ArticleForm(id, null, content);
        String originTitle = "dummy1";
        Article expected = new Article(id, originTitle, content);

        // actual
        Article actual = articleService.update(id, dto);

        // comparison
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @Transactional
    void update_fail_wrong_id() {
        // expected
        Long id = -1L;
        String title = "changedTitle1";
        String content = "changedContent1";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;

        // actual
        Article actual = articleService.update(id, dto);

        // comparison
        assertEquals(expected, actual);
    }

    @Test
    @Transactional
    void update_fail_no_title_no_content() {
        // expected
        Long id = 1L;
        String title = null;
        String content = null;
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, "dummy1", "1111");

        // actual
        Article actual = articleService.update(id, dto);

        // comparison
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @Transactional
    void delete_success_id() {
        // expected
        Long id = 1L;
        String title = "dummy1";
        String content = "1111";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = dto.toEntity();

        // actual
        Article actual = articleService.delete(id);

        // comparison
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    @Transactional
    void delete_fail_wrong_id() {
        // expected
        Long id = -1L;
        Article expected = null;

        // actual
        Article actual = articleService.delete(id);

        // comparison
        assertEquals(expected, actual);
    }
}