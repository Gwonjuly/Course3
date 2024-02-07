package com.example.memoryDB.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//Primarykey(Interace)의 실제 구현체는 아닌 추상 메서드
//@Data: 구조에 id: Long만 있음
//@Data//Entity(),getid,setid,id Long, toString 등등
public abstract class Entity implements PrimaryKey{
    //@Data 필드에 적용이 안된다네?
    @Getter
    @Setter
    private Long id;
}
