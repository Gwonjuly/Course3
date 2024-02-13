package com.example.memoryDB.book.db.repository;

import com.example.memoryDB.DB.SimpleDataRepository;
import com.example.memoryDB.book.db.entity.BookEntity;
import org.springframework.stereotype.Service;

@Service
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {
}
