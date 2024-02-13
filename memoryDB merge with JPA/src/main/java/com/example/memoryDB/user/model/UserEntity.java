package com.example.memoryDB.user.model;

import com.example.memoryDB.Entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
/*
[UserEntity]
db에 저장되기에 Entity를 상속받음
 */
public class UserEntity extends Entity {
    private String name;
    private int score;
}
