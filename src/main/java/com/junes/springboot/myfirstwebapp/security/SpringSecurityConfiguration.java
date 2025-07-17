package com.junes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    //InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails... users)

    // DB 없이 간단하게 로그인 기능 테스트
    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {

        UserDetails userDetails1 = createUserDetails("junes", "1234");
        UserDetails userDetails2 = createUserDetails("janes", "1234");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createUserDetails(String junes, String number) {
        // 입력된 문자열을 Bcrypt를 사용해서 암호화
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input) ;

        UserDetails userDetails = User.builder()
                                    .passwordEncoder(passwordEncoder)
                                    .username(junes)
                                    .password(number)
                                    .roles("USER", "ADMIN")
                                    .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
