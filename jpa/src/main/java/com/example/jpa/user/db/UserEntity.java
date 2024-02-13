package com.example.jpa.user.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="user")//database의 user 테이블과 매칭 시키겠다, ""는 맵핑시킬 테이블 명
/*
ORM
오브젝트를 mapping하기 위해서 Entity라는 어노테이션 사용(user 테이블)
 */
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//위 어노테이션은 id가 primary key 이기 때문에 달아줘야 함(AUTO_INCREMENT) 포함, null 허용 불가 및 자동 생성
    private String name;//null 허용 불가
    private Integer age; //int 보다 Integar 선호, null 허용 및 디폴트 1
    private String email;//null 허용 및 디폴트 ""
}
