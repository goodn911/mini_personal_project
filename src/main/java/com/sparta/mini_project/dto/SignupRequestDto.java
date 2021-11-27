package com.sparta.mini_project.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
public class SignupRequestDto {
    @Pattern(regexp= "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{3,12}$",message="최소 3자이상 숫자+알파벳, 알파벳 대소문자(a~z, A~Z), 숫자(0~9) ")
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String username;


    @NotBlank(message = "최소 4자 이상 패스워드를 입력해주세요")
    @Size(min = 4, max = 20)
    private String password;

    @Size(min = 4, max = 20)
    @NotBlank(message = "최소 4자 이상 패스워드를 입력해주세요")
    private String repassword;

    @Email(message = "이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일는은 필수 입력 값입니다.")
    private String email;



}