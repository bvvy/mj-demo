package com.ying.basis.comment.dto;

import com.ying.basis.comment.model.Comment;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author bvvy
 * @date 2018/9/8
 */
@Data
public class CommentAddDTO {

    private String content;
    private Integer toId;

    private String type;

    public Comment to() {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCdt(LocalDateTime.now());
        comment.setToId(toId);
        comment.setType(type);
        return comment;
    }
}
