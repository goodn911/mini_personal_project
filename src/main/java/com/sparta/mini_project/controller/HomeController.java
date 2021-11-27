package com.sparta.mini_project.controller;

import com.sparta.mini_project.model.Board;
import com.sparta.mini_project.repository.BoardRepository;
import com.sparta.mini_project.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HomeController {

    public final BoardRepository boardRepository;

    //첫 메인화면
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {

        if (userDetails != null) {
            model.addAttribute("username", userDetails.getUsername());
        }else {
            model.addAttribute("username", "guest");
        }

        return "index";

    }
    //게시판 글쓰기 이동
    @GetMapping("/api/boards/write")
    public String write() {
        return "redirect:/write.html";
    }

    //상세페이지 이동동
   @GetMapping("/auth/comment/{id}")
    public String comment(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        Board board = boardRepository.getById(id);

        if (userDetails != null) {



            model.addAttribute("username", userDetails.getUsername());
            model.addAttribute("userId", userDetails.getUser().getId());

        }else {
            model.addAttribute("username", "guest");
        }

        model.addAttribute("board", board);



        return "comment";
    }


}


