package com.sparta.mini_project.security;

import com.sparta.mini_project.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


//스프링 시큐리티가 로그인 요청을 가로채서 로그인 완려되면
//UserDetials 타입의 오브젝트를 스프링시큐리티의 고유한 세션저장소에 저장
@Getter
public class UserDetailsImpl implements UserDetails {

    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    //계정이 만료되지 않았는지 리턴 (true 만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //계정이 잠겨있지 않았는지 리턴(true:잠기지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //비밀번호가 만료되지 않았는지 리턴(true 만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //계정이 활성화 인지 리턴(true 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
}