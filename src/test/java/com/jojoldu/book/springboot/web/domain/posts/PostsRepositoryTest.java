package com.jojoldu.book.springboot.web.domain.posts;


import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        System.out.println("PostsRepositoryTest.cleanup");
       postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given (이런게 주어졌을 때...)            // given : 정해진, 주어진
        LocalDateTime now = LocalDateTime.of(2023, 9, 6, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // when (이런걸 실행했을 때...)            // when : 언제, ~ 했을때
        List<Posts> postList = postsRepository.findAll();

        // then (결과가 이것이어야 돼...)          // then : 그 다음에 , 그리고
        Posts posts = postList.get(0);
        System.out.println(">>>>> posts=" + posts);
        System.out.println(">>>>> createdDate="+ posts.getCreateDate() +", modifiedDate=" + posts.getModifiedDate());;

        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);



    }
}


















