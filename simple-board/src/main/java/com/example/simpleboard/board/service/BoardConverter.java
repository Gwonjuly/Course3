package com.example.simpleboard.board.service;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.board.model.BoardDto;
import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.model.PostDto;
import com.example.simpleboard.post.service.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardConverter {

    private final PostConverter postConverter;

    public BoardDto toDto(BoardEntity boardEntity){

        var list =boardEntity.getPostList().stream()
                //.map(it->{return postConverter.toDto(it)});
                .map(postConverter::toDto)//위 문장을 람다로 표현
                .collect(Collectors.toList());



        return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(list)
                .build();
    }
}
