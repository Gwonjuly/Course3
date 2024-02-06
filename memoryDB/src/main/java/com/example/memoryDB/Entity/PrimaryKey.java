package com.example.memoryDB.Entity;
//프라이머리 키=ID
public interface PrimaryKey {

    //ID 지정 메서드
    void setId(Long id);

    Long getId();
}
