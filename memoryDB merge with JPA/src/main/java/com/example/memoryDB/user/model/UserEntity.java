package com.example.memoryDB.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//@EqualsAndHashCode(callSuper = true)//이거 MemoryDB에 있었음
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")//user라는 테이블과 맵핑, 엔티티는 무조건 프라이머리 키가 있어야 함
public class UserEntity  {

    @Id//프라이머리 키
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    private Long id;

    private String name;
    private int score;
}
