package com.example.memoryDB.book.service;

import com.example.memoryDB.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class BookService {

    @Autowired
    private BookRepository bookRepository;

}
