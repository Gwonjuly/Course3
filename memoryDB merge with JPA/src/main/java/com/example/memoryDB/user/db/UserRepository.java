package com.example.memoryDB.user.db;

import com.example.memoryDB.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    //select *from book_store.user where score>90;
    //finaAll(메서드)/score(필드,컬럼)/GreaterThan(>) or GreaterThanEqual(>=)   score가 sc에 맵핑

    public List<UserEntity>  findAllByScoreGreaterThan(int sc);

    //select * from user where score >=99 ?? AND score <=??
    // score 특정 점수보다 작은 점수 && 특정 점수보다 큰 점수, 근데 public이 없어도 되나벼..

    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    /*//[jpql 방식]
    @Query(
            //value = "select u from user u where u.score >=?1 AND u.score <= ?2"
            //u=*, from user=UserEntity, u.score=UserEntity의 score, ?1=첫번째 변수, ?2=두번째 변수

            //sql 방식
            value = "select * from user as u where u.score>=?1 AND u.score<=?2",
            nativeQuery = true
    )
    List<UserEntity> score(int min,int max);*/

    @Query(
            value = "select * from user as u where u.score >=:min AND u.score<=:max",
            nativeQuery = true
    )
    List<UserEntity> score(
            @Param(value = "min") int min,
            @Param(value = "max") int max
    );
}
