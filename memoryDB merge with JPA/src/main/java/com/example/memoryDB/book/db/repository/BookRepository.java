package com.example.memoryDB.book.db.repository;

import com.example.memoryDB.book.db.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
