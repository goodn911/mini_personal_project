package com.sparta.mini_project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  //기본 생성자를 만듬
@Entity  //테이블과 연계됨을 스피링에게 알려줌
public class Board extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String username;
    @Column
    private String contents;
    @Column
    private String title;

    public Board(String username, String contents, String title) {
        this.username = username;
        this.contents = contents;
        this.title = title;
    }

    public  Board(BoardRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title =requestDto.getTitle();
    }

    public void update(BoardRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title =requestDto.getTitle();
    }
}
