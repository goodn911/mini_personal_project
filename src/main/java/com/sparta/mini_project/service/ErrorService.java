package com.sparta.mini_project.service;

import com.sparta.mini_project.dto.SignupRequestDto;
import com.sparta.mini_project.model.User;
import com.sparta.mini_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ErrorService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Autowired
    public ErrorService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }
    // 회원 ID 중복 확인

    public String userDuplicate(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            String usernameDuplicate = "중복된 사용자 ID 가 존재합니다.";
            return usernameDuplicate;
        }
        return "";
    }
    //비밀번호 아이디 중복
    public String passwordDuplicate(SignupRequestDto requestDto) {
        if (requestDto.getPassword().contains(requestDto.getUsername())) {
            String passwordDuplicate = "아이디와 비밀번호가 비슷합니다.";
            return passwordDuplicate;
        }
        return "";
    }
    //패스워드 불일치
    public String notPassword(SignupRequestDto requestDto) {
        if (!requestDto.getPassword().equals(requestDto.getRepassword())) {
            String notPassword = "패스워드가 일치하지 않습니다.";
            return notPassword;
        }
        return "";
    }
    //이메일 중복

}

