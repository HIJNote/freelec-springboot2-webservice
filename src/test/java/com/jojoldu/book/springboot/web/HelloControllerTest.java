package com.jojoldu.book.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
여기서는 SpringRunner라는 스프링 실행자 사용
스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함
 */
@RunWith(SpringRunner.class)
/*
Web에 집중할 수 있는 어노테이션
@Controller,@ControllerAdvice 등을 사용할 수 있음.
단, @Service,@Component,@Repository 등은 불가능
 */
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    //빈주임
    @Autowired
    /*
    웹 API테스트에 사용됨,스프링MVC테스트의 시작점임.
    이 클래스를 통해 HTTP GET,POST 등에 대한 API테스트 가능
     */
    private MockMvc mvc;
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello="hello";
        /*
       mvc.perform(get("/hello")) MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함

       andExpect(status().isOk()) mvc.perform의 결과를 검증한다. HTTP Header의 Status를 검증한다.
       우리가 흔히 알고 있는 200,404,500등의 상태를 점검하며 여기서는 200(OK)상태를 검증한다.

       andExpect(content().string(hello)) mvc.perform의 결과를 검증한다.
       응답 본문의 내용을 검증한다. Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증한다.
         */
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name="hello";
        int amount=1000;
        mvc.perform(get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)))
                        .andExpect(status().isOk()).andExpect(jsonPath("$.name",is(name)))
                        .andExpect(jsonPath("$.amount",is(amount)));
                        /*
                        jsonPath ->JSON응답값을 필드별로 검증할 수 있는 메소드
                        $를 기준으로 필드명을 명시한다.
                        name,amount를 검증할 것이니 $.name $.amount가 되겠다.
                         */
    }
}
