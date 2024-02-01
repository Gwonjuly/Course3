package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data; //Structure에 생성자,getter setter, tostring 등의 메소드가 생성됨
import lombok.NoArgsConstructor;

@Data //lombok의 어노테이션.
@AllArgsConstructor //전체 파라미터를 가지는 생성자가 생김
@NoArgsConstructor //파라미터가 없는 기본 생성자가 생김
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;
}
