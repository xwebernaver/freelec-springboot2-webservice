package com.jojoldu.book.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩(){
        // given (이런게 주어졌을 때...)            // given : 정해진, 주어진

        // when (이런걸 실행했을 때...)            // when : 언제, ~ 했을때
        String body = this.restTemplate.getForObject("/", String.class);

        System.out.println(">>> body=" + body);

        // then (결과가 이것이어야 돼...)          // then : 그 다음에 , 그리고
        Assertions.assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }

}