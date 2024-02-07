package com.example.memoryDB.user.db;

import com.example.memoryDB.DB.SimpleDataRepository;
import com.example.memoryDB.user.model.UserEntity;
import org.springframework.stereotype.Repository;

@Repository//강의에서는 @Service로 함
public class UserRepository extends SimpleDataRepository<UserEntity,Long> {
    //여기서 SimpleDataRepository의 dataList는 List<UserEntity>
}
