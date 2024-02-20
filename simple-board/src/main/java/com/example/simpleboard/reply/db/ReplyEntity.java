package com.example.simpleboard.reply.db;

import com.example.simpleboard.post.db.PostEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//primary key 설정
    private Long id;

    @ManyToOne//reply(N) : post(1)
    @JsonIgnore//view 시, post와 reply의 무한루프 방지
    @ToString.Exclude//view 시, post와 reply의 무한루프 방지
    private PostEntity post;//자동으로 뒤에 _id 생성

    private String userName;

    private String password;

    private String status;

    private String title;

    private String content;

    private LocalDateTime repliedAt;
}
