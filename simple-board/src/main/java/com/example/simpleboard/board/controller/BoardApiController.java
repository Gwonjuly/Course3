package com.example.simpleboard.board.controller;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.board.model.BoardRequest;
import com.example.simpleboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
요청을 받기 위해 모델 필요하다고 함-> model.BoardRequest
컨트롤러는 요청을 누구한테 받을까? 서버?로 부터 들어온 요청이 boardrequest?
컨트롤러 - 서비스 - 레파지토리 - 엔티티
1. 컨트롤러는 서버로 부터 요청을 받음(boardrequest)
    서비스를 주입 받음
2. 서비스는 컨트롤러로 부터 요청을 받아 레파지토리를 이용해 비즈니스 로직을 처리함

 */
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor//서비스를 주입 받음
public class BoardApiController {

    private final BoardService boardService;
    @GetMapping("")
    public BoardEntity create(//JpaRepository(simple)의 save
            @Valid
            BoardRequest boardRequest//요청은 valid를 통해 검증됨(not blank)
    ){
        return boardService.create(boardRequest);
    }
}
