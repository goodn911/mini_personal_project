package com.sparta.mini_project.controller;


import com.sparta.mini_project.model.Board;
import com.sparta.mini_project.repository.BoardRepository;
import com.sparta.mini_project.dto.BoardRequestDto;
import com.sparta.mini_project.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class BoardController {


    private final BoardRepository boardRepository;
    //게시글 작성 api
    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){
        Long userId = userDetails.getUser().getId();

        Board board = new Board(requestDto, userId);

        return boardRepository.save(board);
    }

    //index 불러오는 api허가
    @GetMapping("/auth/boards")
    public List<Board> getBoard(){

        return boardRepository.findAllByOrderByModifiedAtDesc();
    }


    @DeleteMapping("/api/boards/{id}")
    public Long deleteboard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }


}
