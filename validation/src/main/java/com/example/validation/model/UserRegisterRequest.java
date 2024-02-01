package com.example.validation.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    @NotNull //!=null
    @NotEmpty //!=null && !="", 공백도 아님
    @NotBlank //!=null && !="" && !=" " //blank가 있는 문자도 안됨
    private String name;

    @Size(min=1, max=12)
    @NotBlank
    private String password;//pw는 blank도 안되며 길이는 1~12

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;//나이 최소 한살 최대 100살

    @Email //email 포맷이 들어오도록
    private String email;

    //강의 정규식 참고
   private String phoneNumber;
    private LocalDateTime registerAt;
}
