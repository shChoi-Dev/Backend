package com.spring_boot_jpa_projectEx.project.dto;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.spring_boot_jpa_projectEx.project.entity.MemberEntity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberDTO {
	private String memId;
	private String memPwd;
	private String memName;
	private String memEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date memJoinDate;
	private String memHP;
	private String memZipcode;
	private String memAddress1;
	private String memAddress2;	
		
	public static MemberDTO toDto(MemberEntity entity) {
		return MemberDTO.builder()
				.memId(entity.getMemId())
				.memPwd(entity.getMemPwd())
				.memName(entity.getMemName())
				.memEmail(entity.getMemEmail())
				.memJoinDate(entity.getMemJoinDate())
				.memHP(entity.getMemHP())
				.memZipcode(entity.getMemZipcode())
				.memAddress1(entity.getMemAddress1())
				.memAddress2(entity.getMemAddress2())
				.build();
	}
}
