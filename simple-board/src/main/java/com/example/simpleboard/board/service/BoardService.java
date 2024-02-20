package com.example.simpleboard.board.service;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.board.db.BoardRepository;
import com.example.simpleboard.board.model.BoardDto;
import com.example.simpleboard.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
[서비스는 레파지토리를 주입 받음]
서비스는 레파지토리와 연결되어야 함, 컨트롤러부터 요청을 받음
서비스=비즈니스 로직
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    //사용자가 요청한 이름(request)를 boardname에 지정
    public BoardDto create(BoardRequest boardRequest){//서버->컨트롤러로 부터 들어온 요청
        var entity=BoardEntity.builder()//BoardEntity의 id는 auto_increment라 builder할 필요 없음
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        var saveEntity= boardRepository.save(entity);
        return boardConverter.toDto(saveEntity);
    }


    public BoardDto view(Long id) {//entity view로 내리지 않음
        var entity=boardRepository.findById(id).get();
        return boardConverter.toDto(entity);
    }
}
