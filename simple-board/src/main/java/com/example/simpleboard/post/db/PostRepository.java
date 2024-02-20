package com.example.simpleboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
    // select * from post where id=? and status =? order by id desc limit 1
    //OrderByIdDesc: 최신 것부터 정렬
    public Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);
}
