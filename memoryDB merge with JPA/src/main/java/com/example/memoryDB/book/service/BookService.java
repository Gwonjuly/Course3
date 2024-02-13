package com.example.memoryDB.book.service;

import com.example.memoryDB.book.db.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    /*public BookService(BookRepository bookRepository){//BookService 생 성자를 통해 bookservice가 생성될 때 bookrepository 주입
      this.bookRepository=bookRepository;//bookrepository는 서비스로 등록되어 있음
    }//RequiredArgsConstructor 있으면 위 코드 없어도 됨*/
}
