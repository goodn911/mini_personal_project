package com.sparta.mini_project.controller;

import com.sparta.mini_project.dto.CommentRequestDto;
import com.sparta.mini_project.model.Comment;
import com.sparta.mini_project.repository.CommentRepository;
import com.sparta.mini_project.security.UserDetailsImpl;
import com.sparta.mini_project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;
    //상세페이지 댓글 저장
    @PostMapping("/api/newcomments")
    public Comment createComment(@RequestBody CommentRequestDto commentRequestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){
        Long userId = userDetails.getUser().getId();

        Comment comment =commentService.createComment(commentRequestDto,userId);
        return comment;

    }

    //로그인된 댓글 ID
    @GetMapping("/api/comments")
    public List<Comment> getComment(){

        return commentRepository.findAllByOrderByModifiedAtDesc();
    }



    @DeleteMapping("/api/comments/{id}")
    public Long deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return id;
    }

    @PutMapping("/api/comments/{id}")
    public Long updateComment(@PathVariable Long id,@RequestBody CommentRequestDto requestDto){
        commentService.update(id,requestDto);
        return id;
    }
}
