package com.example.simpleboard.post.db;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne//post는 n이고 boardentity가 1
    @JsonIgnore//board와 post의 무한루프를 막기 위해 post에서 boardentity 참조 시, 직렬화(객체 -> json)을 막음
    @ToString.Exclude////board와 post의 ToString 무한루프를 막기 위해
    private BoardEntity board;//1:N 관계를 위해 수정, @으로 인해 해당 변수를 컬럼으로 인식, board + _id(뒤에 자동으로 붙음)

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    //@Column(columnDefinition = "TEXT")
    private String content;//강의에서는 여기 에러남 난 왜 안나?

    private LocalDateTime postedAt;

    //@Transient//post table의 column으로 사용하지 않음
    @OneToMany(
            mappedBy = "post"
    )
    @Builder.Default
    private List<ReplyEntity> replyList= List.of();//post view 시, reply도 같이 보이도록(default로 빈 클래스를 지정한다는데, list.of는 null이 못 옴)
}
