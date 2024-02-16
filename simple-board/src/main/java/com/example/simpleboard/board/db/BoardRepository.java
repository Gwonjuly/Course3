package com.example.simpleboard.board.db;

import org.springframework.data.jpa.repository.JpaRepository;
//레파지토리는 엔티티와 연결
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
}
