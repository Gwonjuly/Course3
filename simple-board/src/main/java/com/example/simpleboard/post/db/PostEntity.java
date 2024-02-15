package com.example.simpleboard.post.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*@Getter
@Setter
@ToString*/
@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//primary key 설정
    private Long id;

    private Long boardId;

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    //@Column(columnDefinition = "TEXT")
    private String content;//강의에서는 여기 에러남 난 왜 안나?

    private LocalDateTime postedAt;

}
