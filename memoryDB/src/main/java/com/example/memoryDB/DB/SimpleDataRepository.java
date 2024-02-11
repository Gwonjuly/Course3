package com.example.memoryDB.DB;

import com.example.memoryDB.Entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

/*
DataRepository를  구현 또는 미 구현 하는 추상 클래스
 */
public abstract class SimpleDataRepository<T extends Entity,ID extends Long> implements DataRepository<T,ID> {
    //simple이 받는 리스트
    private List<T> dataList=new ArrayList<>();

    //고유 id 부여를 위함(0부터 시작)
    private static long index=0;

    //sorting
    private Comparator<T> sort=new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            //사용자 작성
            return Long.compare(o1.getId(), o2.getId());
            /*
            o1 < o2 ==> -1
            o1 == o2 ==> 0
            o1 > o2 ==> 1
             */
        }
    };

    //create, 데이터가 들어오면 데이터 리스트에 add
    @Override
    public T save(T data) {

        if(Objects.isNull(data))
            //return null;
            throw new RuntimeException("Data is null");
        //db에 데이터(id)가 있는가?
        var preData=dataList.stream()
                .filter(it->{
                    return it.getId().equals(data.getId());})
                .findFirst();

        //preData가 있는가?
        if(preData.isPresent()){
            //기존 데이터 있음:update
            //dataList.remove(preData);//preData=Optional<UserEntity>, userEntity와 동일한 객체를 가지고 있는 객체가 list에 없기에 삭제가 되지 않음'
            dataList.remove(preData.get());//이렇게 해줘야 함
            dataList.add(data);
        }
        else{
            //기존 데이터 없음: save
            data.setId(++index); //왜 전위로 하는거지..? 인덱스가 1부터 가나?
            dataList.add(data);
       }

        //unique id
        //data.setId(); 에러발생: data가 제네릭 타입이기 때문에, SimpleDataRepository<T,ID> ->SimpleDataRepository<T extends Entity,ID extends Long>
        /*data.setId(index);//T=Entity라고 생각하면 됨
        dataList.add(data);
        index++;*/
        return data;
    }

    //read
    @Override
    public Optional<T> findById(ID id){
        return dataList.stream()
                .filter(it->{
                    return it.getId().equals(id);})
                .findFirst();
    }
    @Override
    public List<T> findAll(){
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    //delete
    @Override
    public void delete(ID id){
        var deleteEntity=dataList.stream()
                .filter(it->{return it.getId().equals(id);})
                .findFirst();
        if(deleteEntity.isPresent())
            dataList.remove(deleteEntity.get());//여기도 .get()을 해줘야 객체의 인덱스를 찾아 삭제함
    }
}
