package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest // The test is performed in conjunction with JPA
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("select all comments in specific article")
    void findByArticleId() {
        /* Case 1: select all comments in article 4 */
        {
            // set input data
            Long articleId = 4L;

            // actual
            List<Comment> actual = commentRepository.findByArticleId(articleId);

            // expected
            Article article = new Article(4L, "title1", "content1");
            Comment a = new Comment(1L, article, "user1", "comment4-1");
            Comment b = new Comment(2L, article, "user2", "comment4-2");
            Comment c = new Comment(3L, article, "user3", "comment4-3");
            List<Comment> expected = Arrays.asList(a, b, c);

            // verification
            assertEquals(expected.toString(), actual.toString(), " select all comments in article 4");
        }

        /* Case 2: select all comments in article 1 */
        {
            // set input data
            Long articleId = 1L;

            // actual
            List<Comment> actual = commentRepository.findByArticleId(articleId);

            // expected
            Article article = new Article(1L, "AAAA", "1111");
            List<Comment> expected = Arrays.asList();

            // verification
            assertEquals(expected.toString(), actual.toString(), " select all comments in article 1");
        }

        /* Case 3: select all comments in article 9 */
        {
            // set input data
            Long articleId = 9L;

            // actual
            List<Comment> actual = commentRepository.findByArticleId(articleId);

            // expected
            Article article = null;
            List<Comment> expected = Arrays.asList();

            // verification
            assertEquals(expected, actual, " select all comments in article 9");
        }

        /* Case 4: select all comments in article 9999 */
        {
            // set input data
            Long articleId = 999L;

            // actual
            List<Comment> actual = commentRepository.findByArticleId(articleId);

            // expected
            Article article = null;
            List<Comment> expected = Arrays.asList();

            // verification
            assertEquals(expected, actual, " select all comments in article 999");
        }

        /* Case 5: select all comments in article -1 */
        {
            // set input data
            Long articleId = -1L;

            // actual
            List<Comment> actual = commentRepository.findByArticleId(articleId);

            // expected
            Article article = null;
            List<Comment> expected = Arrays.asList();

            // verification
            assertEquals(expected, actual, " select all comments in article -1");
        }
    }

    @Test
    @DisplayName("select all comments of specific user")
    void findByNickname() {
        /* Case 1: select all comments of user1 */
        {
            // set input data
            String nickname = "user1";

            // actual
            List<Comment> actual = commentRepository.findByNickname(nickname);

            // expected
            Comment a = new Comment(1L, new Article(4L, "title1", "content1"), "user1", "comment4-1");
            Comment b = new Comment(4L, new Article(5L, "title2", "content2"), "user1", "comment5-1");
            Comment c = new Comment(7L, new Article(6L, "title3", "content3"), "user1", "comment6-1");
            List<Comment> expected = Arrays.asList(a, b, c);

            // verification
            assertEquals(expected.toString(), actual.toString(), " print all comments of user1");
        }

        /* Case 2: select all comments of user2 */
        {
            // set input data
            String nickname = "user2";

            // actual
            List<Comment> actual = commentRepository.findByNickname(nickname);

            // expected
            Comment a = new Comment(2L, new Article(4L, "title1", "content1"), "user2", "comment4-2");
            Comment b = new Comment(5L, new Article(5L, "title2", "content2"), "user2", "comment5-2");
            Comment c = new Comment(8L, new Article(6L, "title3", "content3"), "user2", "comment6-2");
            List<Comment> expected = Arrays.asList(a, b, c);

            // verification
            assertEquals(expected.toString(), actual.toString(), " print all comments of user2");
        }

        /* Case 3: select all comments of null */
        {
            // set input data
            String nickname = null;

            // actual
            List<Comment> actual = commentRepository.findByNickname(nickname);

            // expected
            Comment comment = null;
            List<Comment> expected = Arrays.asList();

            // verification
            assertEquals(expected, actual, " print all comments of null");
        }

        /* Case 4: select all comments of "" */
        {
            // set input data
            String nickname = "";

            // actual
            List<Comment> actual = commentRepository.findByNickname(nickname);

            // expected
            Comment comment = null;
            List<Comment> expected = Arrays.asList();

            // verification
            assertEquals(expected, actual, " print all comments of \"\"");
        }

        /* Case 5: select all comments contain "i" */
        {
            // set input data
            String nickname = "*i*";

            // actual
            List<Comment> actual = commentRepository.findByNickname(nickname);

            // expected
            Comment comment = null;
            List<Comment> expected = Arrays.asList();

            // verification
            assertEquals(expected, actual, " print all comments of user who contain spell 'i'");
        }
    }
}