package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
lombok의 어노테이션
@Getter
@NoArgsConstructor 어노테이션은 파라미터가 없는 기본 생성자를 생성해주고,
@AllArgsConstructor 어노테이션은 모든 필드 값을 파라미터로 받는 생성자를 만들어줍니다.
@RequiredArgsConstructor 어노테이션은 final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 만들어줍니다.
 */
@Getter
@NoArgsConstructor //기본생성자 생성
@Entity
public class Posts {
    /*
    @Entity : 테이블과 링크될 클래스
    @Id 해당 테이블의 PK필드
    @GeneratedValue PK생성규칙,스프링부트2.0에서는 GeneratedType.IDENTITY옵션을 추가해야만 auto_increment가 된다.
    @Column 테이블의 컬럼
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500,nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;
    private String author;

    @Builder
    /*
    해당 클래스의 빌더 패턴 클래스 생성
    생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
     */
    public Posts(String title,String content,String author){
        this.title=title;
        this.content=content;
        this.author=author;
    }

}
