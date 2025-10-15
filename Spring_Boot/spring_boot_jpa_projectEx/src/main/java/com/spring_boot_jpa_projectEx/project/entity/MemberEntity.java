package com.spring_boot_jpa_projectEx.project.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.spring_boot_jpa_projectEx.project.dto.MemberDTO;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert // db컬럼의 기본값 적용가능하도록 필드값이 null인경우 insert에서 제외
@DynamicUpdate // db의 기존 레코드와 비교해서 변경된 컬럼만 수정을 진행
@Table(name="MEMBER")
public class MemberEntity {
	@Id
	private String memId;	
	private String memPwd;
	private String memName;
	private String memEmail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(updatable=false)
	private Date memJoinDate; // insert는 진행되지만 update시 해당 필드 제외
	private String memHP;
	private String memZipcode;
	private String memAddress1;
	private String memAddress2;
	
	public void keepPwd(String currentPwd) {
		this.memPwd = currentPwd;
	}
		
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








