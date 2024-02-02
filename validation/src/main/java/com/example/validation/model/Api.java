package com.example.validation.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Api<T> {

    private String resultCode;
    private String resultMsg;

    @Valid//UserRegisterRequest에서 @Valid가 있어도 해당 부분은 요청하는 이곳에서도 @Valid가 있어야 함
    private T data; //data가 object 이기에 body에 표현될 때, "data":{}
    private Error error;//얘도 마찬가지임

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Error{//이너 클래스, @ 필요 함
        private List<String> errorMsg;
    }
}
