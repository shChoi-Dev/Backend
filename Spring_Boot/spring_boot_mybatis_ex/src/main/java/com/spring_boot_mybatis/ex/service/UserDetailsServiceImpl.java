package com.spring_boot_mybatis.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring_boot_mybatis.ex.dao.IMemberDAO;
import com.spring_boot_mybatis.ex.model.MemberVO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IMemberDAO memberDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 로그인 폼에서 전달된 username(memId)으로 DB에서 회원 정보를 조회
        MemberVO member = memberDAO.getMemberInfo(username);

        // 2. 해당 ID의 회원이 존재하지 않으면 예외 발생
        if (member == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        // 3. 조회된 회원 정보를 기반으로 Spring Security의 UserDetails 객체를 생성하여 반환
        //    - {noop}는 암호화 없이 평문 비밀번호를 사용하겠다는 의미지만, 우리는 BCrypt를 사용하므로 붙이지 않음.
        //    - roles("USER")는 이 사용자에게 "USER" 역할을 부여한다는 의미.
        return User.builder()
                .username(member.getMemId())
                .password(member.getMemPwd()) // DB에 저장된 암호화된 비밀번호
                .roles("USER")
                .build();
    }
}