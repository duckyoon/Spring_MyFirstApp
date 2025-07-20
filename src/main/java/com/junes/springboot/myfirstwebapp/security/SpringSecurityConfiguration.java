package com.junes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

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

    // Spring Security 6.x 버전 이후에는 메서드 체이닝 방식 대신 람다 기반의 설정 방식을 사용
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated())
                // 기본 로그인 페이지 활성화
            .formLogin(withDefaults()) // 기본 로그인 페이지 활성화
                //CSRF 보호 비활성화 (개발 환겨에서만 사용)
            .csrf(csrf -> csrf.disable())
                // iframe 허용
            .headers(headers -> headers.frameOptions(fram -> fram.disable()));

        return http.build();
    }
}
