package com.example.simpleboard.reply.service;

import com.example.simpleboard.crud.Converter;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyConverter implements Converter<ReplyDto, ReplyEntity> {
    private final PostRepository postRepository;
    @Override
    public ReplyDto toDto(ReplyEntity replyEntity) {

        var dto= ReplyDto.builder()
                .id(replyEntity.getId())
                .postId(replyEntity.getPost().getId())
                .userName(replyEntity.getUserName())
                .password(replyEntity.getPassword())
                .status(replyEntity.getStatus())
                .title(replyEntity.getTitle())
                .content(replyEntity.getContent())
                .repliedAt(replyEntity.getRepliedAt())
                .build();
        return dto;
    }

    @Override
    public ReplyEntity toEntity(ReplyDto replyDto) {
        var postEntity=postRepository.findById(replyDto.getPostId());
        var entity=ReplyEntity.builder()
                .id(replyDto.getId())
                //.post(postEntity.get())//이렇게 하면 옵셔널 경고 뜸
                .post(postEntity.map(it->{return  it;}).orElseGet(()->null))//.map 없어도 됨
                .userName(replyDto.getUserName())
                .password(replyDto.getPassword())
                .status(replyDto.getStatus())
                .title(replyDto.getTitle())
                .content(replyDto.getContent())
                .repliedAt(replyDto.getRepliedAt())
                .build();
        return entity;
    }
}
