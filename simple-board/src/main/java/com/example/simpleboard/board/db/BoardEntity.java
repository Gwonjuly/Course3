package com.example.simpleboard.board.db;

import com.example.simpleboard.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "board")//board: simple-board의 table 명
/*
Entity는 repository랑 연결 필요
 */
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//primary key 설정
    private Long id;

    private String boardName;

    private String status;

    //@Transient
    @OneToMany(// 1(boardEnity): N(PostEntity)
            mappedBy = "board"//boardEntity는 PostEntity에 있어야 함, 즉, board select 시, 아래 post가 딸려 옴
    )
    @Where(clause = "status='REGISTERED'")//조건 추가: POST의 status가 registered인 것만 표시
    private List<PostEntity> postList=List.of();//보드는 여러 개의 포스트를 가질 수 있음(board : post = 1 : N)
}
