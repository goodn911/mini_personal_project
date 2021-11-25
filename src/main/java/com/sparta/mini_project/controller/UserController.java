package com.sparta.mini_project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.mini_project.dto.SignupRequestDto;
import com.sparta.mini_project.service.KakaoUserService;
import com.sparta.mini_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {


    private final UserService userService;
    private final KakaoUserService kakaoUserService;

    @Autowired
    public UserController(UserService userService, KakaoUserService kakaoUserService) {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;

    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(@Valid SignupRequestDto signupRequestDto, Errors errors, Model model) {
        if (errors.hasErrors()) {

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            return "signup";
        }

        String userDuplicate = userService.registerUser(signupRequestDto);
        String notPassword = userService.notPassword(signupRequestDto);
        String passwordDuplicate = userService.passwordDuplicate(signupRequestDto);


        if (userDuplicate.equals("")&&notPassword.equals("")&&passwordDuplicate.equals("")) {
            return "login";
        }else {
            model.addAttribute("userDuplicate",userDuplicate);
            model.addAttribute("notPassword",notPassword);
            model.addAttribute("passwordDuplicate",passwordDuplicate);

            return "signup";
        }


    }
    @GetMapping("/user/kakao/callback")
    public String kakaoLogin (@RequestParam String code) throws JsonProcessingException {
// authorizedCode: 카카오 서버로부터 받은 인가 코드
        kakaoUserService.kakaoLogin(code);

        return "redirect:/";
    }
}

