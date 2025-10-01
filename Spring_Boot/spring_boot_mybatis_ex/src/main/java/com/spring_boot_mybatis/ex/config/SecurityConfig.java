package com.spring_boot_mybatis.ex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // Spring Security를 활성화함을 의미
public class SecurityConfig {

    // 비밀번호 암호화를 위한 Bean 생성
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Spring Security의 필터 체인 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 1. 특정 URL에 대한 접근 권한 설정
        http.authorizeHttpRequests(auth -> auth
                // "/", "/js/**", "/css/**", "/images/**" 등 정적 리소스와
                // 회원가입(/signup), 회원가입 처리(/member/join) 경로는 누구나 접근 가능
                .requestMatchers("/", "/js/**", "/css/**", "/images/**", 
                                 "/signup", "/member/join", "/login").permitAll()
                // 그 외의 모든 요청은 인증된 사용자만 접근 가능
                .anyRequest().authenticated()
            );

        // 2. 커스텀 로그인 설정
        http.formLogin(form -> form
                // 사용자가 직접 만든 로그인 페이지 경로
                .loginPage("/login")
                // 로그인 폼의 action URL. Spring Security가 이 요청을 가로채 로그인을 처리함
                .loginProcessingUrl("/login")
                // 로그인 성공 후 이동할 기본 URL
                .defaultSuccessUrl("/", true)
                // 로그인 실패 시 이동할 URL
                .failureUrl("/login?error=true")
                .permitAll()
            );

        // 3. 로그아웃 설정
        http.logout(logout -> logout
                // 로그아웃을 처리할 URL
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // 로그아웃 성공 시 이동할 URL
                .logoutSuccessUrl("/")
                // 로그아웃 시 세션 무효화
                .invalidateHttpSession(true)
            );
        
        // CSRF 보호 비활성화 (개발 편의를 위해 임시로, 실제 운영 환경에서는 활성화 필요)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}