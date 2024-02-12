package com.example.jpa.db;

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
@Entity(name="user")//database의 user 테입블과 매칭 시키겠다
public class UserEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//위 어노테이션은 id가 primary key 이기 때문에 달아줘야 함(AUTO_INCREMENT) 포함
    private String name;
    private Integer age; //int 보다 Integar 선호
    private String email;
}
