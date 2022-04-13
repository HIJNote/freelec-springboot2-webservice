package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

/*
SessionUser에는 인증된 사용자 정보만 필요
User클래스는 엔티티라서 성능이슈,부수효과 발생 할까봐
따로 하나 세션담는 객체 추가함
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;
    public SessionUser(User user){
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }
}
