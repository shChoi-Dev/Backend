package com.spring_boot_react.project.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported=false) // 인증 기능이므로 rest api로 사용하면 안됨 - 해당
public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	Optional<AppUser> findByUsername(String username); // username으로 특정 사용자 추출
}
