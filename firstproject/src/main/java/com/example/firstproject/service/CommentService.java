package com.example.firstproject.service;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;

    public List<CommentDto> comments(Long articleId) {
//        // view comment list
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//
//        // transfer Entity to dto
//        ArrayList<CommentDto> dtos = new ArrayList<CommentDto>();
//        for (int i = 0; i < comments.size(); i++) {
//            Comment c = comments.get(i);
//            CommentDto dto = CommentDto.createCommentDto(c);
//            dtos.add(dto);
//        }
//
//        // return
//        return dtos;

        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) {
        // select article and throw an exception
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("!-Fail to create a comment. There is no target article-!"));

        // create comment Entity
        Comment comment = Comment.createComment(dto, article);

        // save comment Entity to DB
        Comment created = commentRepository.save(comment);

        // return converted dto from entity
        return CommentDto.createCommentDto(created);
    }

    @Transactional
    public CommentDto update(Long id, CommentDto dto) {
        // select comment and throws an exception
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("!-Fail to update. There is no target comment-!"));

        // update comment
        target.patch(dto);

        // save to DB
        Comment updated = commentRepository.save(target);

        // return converted dto from entity
        return CommentDto.createCommentDto(updated);
    }

    @Transactional
    public CommentDto delete(Long id) {
        // select target comment
        Comment target = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("!-Fail to delete. There is no target comment-!"));

        // delete target in DB
        commentRepository.delete(target);

        // return converted dto from entity
        return CommentDto.createCommentDto(target);
    }
}
