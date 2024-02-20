package com.example.simpleboard.reply.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity,Long> {
    // select * from reply(table) where post_id=? and status=? order by id idesc
    //OrderByIdDesc: 최신거부터 정렬
    List<ReplyEntity> findAllByPostIdAndStatusOrderByIdDesc(Long postId, String status);
}
