package com.example.simpleboard.post.controller;

import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import com.example.simpleboard.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
//컨트롤러는 서비스를 주입 받아야 함
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("")
    public PostEntity create(
            @Valid
            @RequestBody PostRequest postRequest//post 요청 검증
    ){
        return postService.create(postRequest);
    }

    @PostMapping("/view")
    public PostEntity view(
            @Valid
            @RequestBody PostViewRequest postViewRequest//게시글 클릭 시, post_id와 비밀번호 필요(입력)
            )
    {
        return postService.view(postViewRequest);//클릭한 게시글과 post_id가 있어야 하고 입력한 비밀번호가 일치해야 함
    }

    @GetMapping("/all")
    public List<PostEntity> list(){
        return postService.all();
    }

    //@DeleteMapping("") 사용 불가: 비밀번호 입력 필요 -> post
    @PostMapping("/delete")
    public void delete(
            @RequestBody PostViewRequest postViewRequest
    ){
        postService.delete(postViewRequest);//클릭한 비밀번호가 일치해야 삭제 가능
    }
}
