package com.spring_boot_react.project.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring_boot_react.project.domain.AppUser;
import com.spring_boot_react.project.domain.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AppUserRepository repository;
	
	public UserDetailsServiceImpl(AppUserRepository repository) {
		this.repository = repository;
	}
	
	// 인증에 사용할 특정 레코드 정보를 담고있는 User 객체(UserDetails 객체 반환)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> user = repository.findByUsername(username); //db 테이블의 특정 레코드 추출(로그인하기위해 전달된 username을 조건으로 추출)
		// 스프링 시큐리티 인증에 필요한 사용자 정보 User 객체(userDetails 객체)가 전달되어야 인증처리 가능
		
		UserBuilder builder = null;
		
		//Optional 객체에 AppUser 인스턴스가 있으면(username에 해당하는 레코드가 반환되었으면
		if(user.isPresent()) {
			// UserDetails 객체 생성(인증에 필요한 컬럼 정보만 저장)
			AppUser currentUser = user.get(); // entity 객체
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(currentUser.getPassword());
			builder.roles(currentUser.getRole()); //builder 클래스 인스턴스에 username, password, role의 data가 entity -> builder 객체로 복사됨
		}else {
			throw new UsernameNotFoundException("User not found");
		}
		return builder.build();
	}
	
}
