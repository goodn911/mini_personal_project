package com.sparta.mini_project.model;


import com.sparta.mini_project.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  //기본 생성자를 만듬
@Entity
public class Comment extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column
    private String username;
    @Column
    private String comments;
    @Column
    private Long userId;


    public Comment(CommentRequestDto requestDto,Long userId) {
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
        this.userId=userId;
    }

    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }
}
