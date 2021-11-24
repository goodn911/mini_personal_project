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

        @GetMapping("/")
        public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
                model.addAttribute("username", userDetails.getUsername());
                return "index";
        }

        @GetMapping("/api/boards/write")
        public String write( ){
                return "redirect:/write.html";
        }

        @GetMapping("/api/comment/{id}")
        public String comment(@PathVariable Long id,@AuthenticationPrincipal UserDetailsImpl userDetails,Model model){
                Board board = boardRepository.getById(id);
                model.addAttribute("username", userDetails.getUsername());
                model.addAttribute("board",board);

                return "comment";
        }


}


