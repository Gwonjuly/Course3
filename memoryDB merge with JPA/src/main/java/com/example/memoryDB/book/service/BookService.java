package com.example.memoryDB.book.service;

import com.example.memoryDB.book.db.entity.BookEntity;
import com.example.memoryDB.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {


    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    //create, updates
    public BookEntity create(BookEntity book){
        return bookRepository.save(book);
    }
    //all
    public List<BookEntity> findAll(){
        return bookRepository.findAll();
    }
    //delete

    //find one

}
