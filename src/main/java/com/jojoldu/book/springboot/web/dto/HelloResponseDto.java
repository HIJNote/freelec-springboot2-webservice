package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
선언된 모든 필드의 get메소드를 대신 생성 lombok기능
 */
@Getter
/*
선언된 모든 final필드가 포함된 생성자를 생성해 줌, final이 없는 필드는 생성자에 포함되지 않는다.
 */
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
