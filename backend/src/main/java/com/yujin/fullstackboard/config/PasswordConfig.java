package com.yujin.fullstackboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//  - @Configuration: Spring 설정 클래스
//  - @Bean: 반환 객체를 Spring이 관리하게 함
//  - BCrypt: 비밀번호를 복구할 수 없는 형태로 암호화
@Configuration
public class PasswordConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
