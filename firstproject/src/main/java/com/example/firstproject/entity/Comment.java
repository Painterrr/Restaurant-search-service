package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // this many comment entity has relationship with one article
    @JoinColumn(name = "article_id") // column name
    private Article article;

    private String nickname;

    private String body;


    public static Comment createComment(CommentDto dto, Article article) {
        // throw an exception
        if (dto.getId() != null)
            throw new IllegalArgumentException("!-Fail to create a comment. Don't need comment id-!");
        if (dto.getArticleId() != article.getId())
            throw new IllegalArgumentException("!-Fail to create a comment. It has a different articleId with article-!");

        // create entity and return
        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {
        // throws an exception
        if (this.id != dto.getId())
            throw new IllegalArgumentException("!-Fail to update. Wrong comment id-!");

        // update object
        if (dto.getNickname() != null)
            this.nickname = dto.getNickname();

        if (dto.getBody() != null)
            this.body = dto.getBody();
    }
}
