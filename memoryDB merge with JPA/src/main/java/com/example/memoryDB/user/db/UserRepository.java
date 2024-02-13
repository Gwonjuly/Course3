package com.example.memoryDB.user.db;

import com.example.memoryDB.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<UserEntity,Long> {

}
