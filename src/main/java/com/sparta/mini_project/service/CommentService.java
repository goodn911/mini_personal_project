package com.sparta.mini_project.service;

import com.sparta.mini_project.dto.CommentRequestDto;
import com.sparta.mini_project.model.*;
import com.sparta.mini_project.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

    //final 필수 요소에대해 생성자를 요청
@Service

public class CommentService {


    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository=commentRepository;

    }

    //상세페이지 댓글&아이디 저장

    public Comment createComment(CommentRequestDto commentRequestDto, Long userId) {
        Comment comment = new Comment(commentRequestDto,userId);

        commentRepository.save(comment);
        return  comment;
    }

    @Transactional  //db에 변경값이 들어가도록 하는것
    public Long update(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(requestDto);
        return comment.getId();
    }




}

