package com.sparta.mini_project.model;

import com.sparta.mini_project.dto.BoardRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor  //기본 생성자를 만듬
@AllArgsConstructor

@Entity  //테이블과 연계됨을 스피링에게 알려줌
public class Board extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Long userId;



    public  Board(BoardRequestDto requestDto, Long userId){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
        this.title =requestDto.getTitle();
        this.userId = userId;

    }

}
