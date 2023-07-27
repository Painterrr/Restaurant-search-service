package com.example.firstproject.repository;

import com.example.firstproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// extends PagingAndSortingRepository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // select all comments in one article
    @Query(value =
            "SELECT * " +
            "FROM comment " +
            "WHERE article_id = :articleId",
            nativeQuery = true)
    List<Comment> findByArticleId(@Param("articleId") Long articleId);

    // select all comments written by specific user. using xml

    List<Comment> findByNickname(@Param("nickname") String nickname);

}