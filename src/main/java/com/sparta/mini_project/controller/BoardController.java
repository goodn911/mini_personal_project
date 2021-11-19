package com.sparta.mini_project.controller;


import com.sparta.mini_project.domain.Board;
import com.sparta.mini_project.domain.BoardRepository;
import com.sparta.mini_project.domain.BoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class BoardController {


    private final BoardRepository boardRepository;

    @PostMapping("/api/boards")
    public Board createBoard(@RequestBody BoardRequestDto requestDto){
        Board board = new Board(requestDto);
        return boardRepository.save(board);
    }
    @GetMapping("/api/boards")
    public List<Board> getBoard(){
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }
    @DeleteMapping("/api/boards/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return id;
    }

}
