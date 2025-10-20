package com.spring_boot_react.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User; // 필드 id, pass, roles
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.spring_boot_react.project.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity // 스프링시큐리티가 제공하는 기본 웹보호 구성이 아닌 현재 파일에서의 구성을 사용
public class SecurityConfig {
	
	//InMemoryUser 구성 변경 : 패스워드가 자동 생성되는걸 여기서 설정한 패스워드로 변경
//	@Bean
//	public InMemoryUserDetailsManager userDetailService() {
//		UserDetails user = User.builder()
//						   	   .username("user")
//						   	   .password(passwordEncoder().encode("password")) //평문 암호화해서 user 생성
//						   	   .roles("USER")
//						   	   .build(); // UserDetails 객체 반환(User를 표현하는 객체)
//		return new InMemoryUserDetailsManager(user); // InMemoryUser 추가
//	}
	
	// DB 사용자 이용하도록 설정 메서드
	// 로그인 요청하면(controller) -> service -> repo -> db
	// 기본 로그인 로직은 security login 처리를 사용
	// 서비스를 활용하는걸 권장
	
	private final UserDetailsServiceImpl userDetailsService;
	
	// di
	public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); // 시큐리티 로그인은 비밀번호에 대해 해시값 매칭으로 확인 
		// 인증처리를 진행하는 service 객체를 생성해서 반환, 파라미터로 개발자가 필요한 서비스 전달가능
		// 패스워드 매치까지 auth에서 진행하도록 구성
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
