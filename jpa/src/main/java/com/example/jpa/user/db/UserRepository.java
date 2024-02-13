package com.example.jpa.user.db;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository: spring에서 해당을 통해 simple을 구현해놨음
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
