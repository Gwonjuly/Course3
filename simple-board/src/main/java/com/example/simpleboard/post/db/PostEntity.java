package com.example.simpleboard.post.db;

import com.example.simpleboard.reply.db.ReplyEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

    @Transient//post table의 column으로 사용하지 않음
    private List<ReplyEntity> replyList= List.of();//post view 시, reply도 같이 보이도록(default로 빈 클래스를 지정한다는데, list.of는 null이 못 옴)
}
