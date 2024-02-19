package com.example.simpleboard.post.service;

import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//서비스는 레파지터리를 주입 받아야 함
@RequiredArgsConstructor
@Service

public class PostService {

    private final PostRepository postRepository;

    public PostEntity create(
            PostRequest postRequest
    ){
        var entity=PostEntity.builder()
                .boardId(1L)//임시 고정
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();
        return postRepository.save(entity);
    }

    /**
     * 1. 게시글이 있는가?
     * 2. 비밀번호가 맞는가?
     * findById의 반환형은 Optional<T>
     * @param postViewRequest
     * @return
     */
    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(),"REGISTERED")//optional
                .map(it->{
                    //it: 객체가 존재할 할 때만 map 가능
                    if(!it.getPassword().equals(postViewRequest.getPassword())){//it(글) 있지만 비밀 번호가 맞지 앟을 경우
                        var format="패스워드가 맞지 않습니다. %s vs %s";
                        throw new RuntimeException(String.format(format,it.getPassword(),postViewRequest.getPassword()));
                    }
                    return it; //it(글) 있고 패스워도 맞는 경우
                }).orElseThrow(//it(글)가 없는 경우
                        ()->{return new RuntimeException("해당 글이 존재하지 않습니다.:"+postViewRequest.getPostId());}
                );
    }

    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getPostId())
                .map(it->{
                    if(!it.getPassword().equals(postViewRequest.getPassword())){
                        var format="패스워드가 맞지 않습니다. %s vs %s";
                        throw new RuntimeException(String.format(format,it.getPassword(),postViewRequest.getPassword()));
                    }
                    it.setStatus("UNREGISTERED");
                    postRepository.save(it);
                    return it;//map은 return 필수임
                }).orElseThrow(
                        ()->{return new RuntimeException("해당 게시글이 존재하지 않습니다."+postViewRequest.getPostId());}
                );
    }
}
