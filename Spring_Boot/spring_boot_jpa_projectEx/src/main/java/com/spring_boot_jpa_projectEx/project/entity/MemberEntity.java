package com.spring_boot_jpa_projectEx.project.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.spring_boot_jpa_projectEx.project.dto.MemberDTO;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="MEMBER")
public class MemberEntity {
	@Id
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
		
	public static MemberEntity toEntity(MemberDTO dto) {
		return MemberEntity.builder()
				.memId(dto.getMemId())
				.memPwd(dto.getMemPwd())
				.memName(dto.getMemName())
				.memEmail(dto.getMemEmail())
				.memJoinDate(dto.getMemJoinDate())
				.memHP(dto.getMemHP())
				.memZipcode(dto.getMemZipcode())
				.memAddress1(dto.getMemAddress1())
				.memAddress2(dto.getMemAddress2())
				.build();
	}

}








