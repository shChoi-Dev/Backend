package com.spring_boot_react.project.service;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts; //token 정보 저장 클래스
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

import java.security.Key;

@Component
public class JwtService {
	// 토큰 만료시간
	static final long EXPIRATIONTIME = 86400000; // 1DAY ms
	static final String PREFIX = "Bearer"; //jwt 일반적으로 사용하는 접두사
	
	// header.payload.서명(인증키) - application 구성파일에서 읽어와야 함
	static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	public String getToken(String username) { //jwt 토큰 생성
		String token = Jwts.builder().setSubject(username)
					  				 .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME)) //토큰 유효기간
					  				 .signWith(key)
					  				 .compact(); // 토큰 생성 xxxx.yyyy.zzzz
					  
		return token;
	}
	
	// 토큰 유효성 검사, 사용자를 리턴
	// 로그인 완료 -> 토큰 전달 -> 다음 요청시 클라이언트 토큰을 헤더에 저장해서 요청함
	public String getAuthUser(HttpServletRequest request) {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(token != null) { // 토큰 유효성 검사
			// user 정보 추출
			String user =  Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token.replace(PREFIX, ""))
					.getBody().getSubject();
			
			// user 있으면
			if(user != null) {
				return user; // 토큰은 유효하고 인증자에 대한 정보 반환
			}
		}
		return null;
	}
}
