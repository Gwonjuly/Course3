package com.example.memoryDB.DB;

import java.util.List;
import java.util.Optional;

/*
Repository를 상속받는 인터페이스
CRUD 기능을 가짐
 */
public interface DataRepository<T,ID> extends Repository<T,ID> {
//? public 생략해서 default?
    //[Create] ID가 없으면, save=데이터 타입을 가진 데이터를 저장 후, 데이터 타입 리턴
    //[Updata] ID가 있으면, 업데이트
    T save(T data);

    //[Read] 데이터의 아이디를 통해서 데이터를 리턴
    Optional<T> findById(ID id); //Optional<T>: null이 올 수 있는 값을 감싸는 Wrapper 클래스

    List<T> findAll();//모두 리턴해주는 메소드

    //[delete]
    void delete(ID id);
}
