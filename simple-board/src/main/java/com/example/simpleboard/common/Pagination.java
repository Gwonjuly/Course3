package com.example.simpleboard.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {

    private Integer page;//현재 페이지(보여주길 요청한 페이지)
    private Integer size;//보여주길 요청한 포스트 수
    private Integer currentElements;//요청한 페이지(현재 페이지)에 있는 포스트 수
    private Integer totalPage;//전체 페이지
    private Long totalElements;//전체 포스트 수
}
