package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)//해당 클래스의 변수들은 Snake case로 맵핑시킴
public class UserInfo {
    private String name;
    //private String phone;
    private int age;
    private String email;
    private Boolean isKorean;

    /*@JsonProperty("user_name")
    private String name;
    @JsonProperty("user_agee");
    private int age;
    @JsonProperty("email");
    private String email;
    @JsonProperty("is_korean");
    private Boolean isKorean;*/
}
