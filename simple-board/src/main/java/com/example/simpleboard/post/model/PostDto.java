package com.example.simpleboard.post.model;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {

    private Long id;

    private Long boardId;//Entity가 아니기에 자동으로 _id가 붙지 않음

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    //@Column(columnDefinition = "TEXT")
    private String content;//강의에서는 여기 에러남 난 왜 안나?

    private LocalDateTime postedAt;
}
