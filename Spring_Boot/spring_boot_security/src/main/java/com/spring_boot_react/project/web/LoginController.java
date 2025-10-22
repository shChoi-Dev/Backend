package com.spring_boot_react.project.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring_boot_react.project.domain.AccountCredentials;
import com.spring_boot_react.project.service.JwtService;

@RestController
public class LoginController {

	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public LoginController(JwtService jwtService, AuthenticationManager authenticationManager) {
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager; // config에 authManager가 구성되어 있어야 함
	}
	
	@PostMapping("/login") // id, pwd를 전송받아 로그인 처리(인증 -> 토큰 포함 응답)
	public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
		// 인증처리를 위한 인증객체를 구성
		UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(credentials.username(), credentials.password());
		Authentication auth = authenticationManager.authenticate(creds);
		
		String jwts = jwtService.getToken(auth.getName());
		
		return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer" + jwts)
				.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization").build();
	}
}
