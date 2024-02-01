package com.example.restapi;

import com.example.restapi.model.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired//Spring에서 관리하는 bin 들 중에 자동으로 생성되는 Object Mapper를 가져오겠다 라는 뜻 (DTO -> JSON)
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		// TODO: 2024-01-29  UerInfo의 내용을 직렬화(오브젝트 매퍼)룰 옿해서 제이슨으로 만들기
		var user=new UserInfo("홍길동",10,"@email",true);

		var json=objectMapper.writeValueAsString(user);//직렬화를 위해 쓰기가  필요
		System.out.println(json);
		//json: {"name":"홍길동","age":10,"email":"@email","is_korean":true}

		var dto=objectMapper.readValue(json, UserInfo.class);//역직렬화를 위해 읽기 필요
		System.out.println(dto);
		//dto: UserInfo(name=홍길동, age=10, email=@email, isKorean=true)
}

}
