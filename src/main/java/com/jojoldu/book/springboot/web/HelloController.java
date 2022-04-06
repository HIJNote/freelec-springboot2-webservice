package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController
컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌
@ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있도록 해줌
 */
@RestController
public class HelloController {
    /*
    HTTP method중 get방식의 요청을 받아들임
    @RequestMapping(method=RequestMethod.GET)이랑 같은 의미임
     */
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,@RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
