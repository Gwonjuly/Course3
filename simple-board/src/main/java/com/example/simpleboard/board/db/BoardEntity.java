package com.example.simpleboard.board.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
}
