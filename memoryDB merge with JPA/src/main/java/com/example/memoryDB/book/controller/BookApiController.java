package com.example.memoryDB.book.controller;

import com.example.memoryDB.book.db.entity.BookEntity;
import com.example.memoryDB.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

    private final BookService bookService;

    @PutMapping("")//강의에서 이거 post로 함 실수인거 같음
    public BookEntity create(
            @RequestBody BookEntity bookEntity
    ){
        return bookService.create(bookEntity);
    }

    @GetMapping("/all")
    public List<BookEntity> findAll(){
        return bookService.findAll();
    }
}
