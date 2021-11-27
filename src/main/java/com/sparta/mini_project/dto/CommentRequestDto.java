package com.sparta.mini_project.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private Long postId;
    private String username;
    private String comments;
    private Long userId;
}
