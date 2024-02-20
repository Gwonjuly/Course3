package com.example.simpleboard.reply.service;

import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.db.ReplyRepository;
import com.example.simpleboard.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;

    public ReplyEntity create(ReplyRequest replyRequest){
        var optionalPostEntity=postRepository.findById(replyRequest.getPostId());
        if(optionalPostEntity.isEmpty()){
            throw new RuntimeException("게시물이 존재하지 않습니다: "+replyRequest.getPostId());
        }
        var entity=ReplyEntity.builder()
                .post(optionalPostEntity.get())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .repliedAt(LocalDateTime.now())
                .build();
        return replyRepository.save(entity);
    }
    //게시글 view를 눌렀을 때, 게시글과 답변(id,title,date,관리자)가 같이 보여야 함
    public List<ReplyEntity> findAllByPostId(Long postId){//postid 받을 때 답변도 같이 보이도록,post view에서 수정 필요
        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId,"REGISTERED");
}
}
