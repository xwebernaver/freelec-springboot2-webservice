package com.jojoldu.book.springboot.web;


import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfileControllerUnitTest {

    @Test
    public void real_profile이_조회된다() {
        // given (이런게 주어졌을 때...)            // given : 정해진, 주어진
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        // when (이런걸 실행했을 때...)            // when : 언제, ~ 했을때
        String profile = controller.profile();

        // 왜 설정값 출력이 안되지???
        System.out.println("server.port > " + env.getProperty("server.port"));

        // then (결과가 이것이어야 돼...)          // then : 그 다음에 , 그리고
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void real_profile이_없으면_첫_번재가_조회된다() {

        // given (이런게 주어졌을 때...)            // given : 정해진, 주어진
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();

        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        // when (이런걸 실행했을 때...)            // when : 언제, ~ 했을때
        String profile = controller.profile();

        // then (결과가 이것이어야 돼...)          // then : 그 다음에 , 그리고
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void active_profile이_없으면_default가_조회된다() {

        // given (이런게 주어졌을 때...)            // given : 정해진, 주어진
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();

        ProfileController controller = new ProfileController(env);

        // when (이런걸 실행했을 때...)            // when : 언제, ~ 했을때
        String profile = controller.profile();

        // then (결과가 이것이어야 돼...)          // then : 그 다음에 , 그리고
        assertThat(profile).isEqualTo(expectedProfile);

    }

}











