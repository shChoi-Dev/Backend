package com.spring.mvcProject.dao;

import com.spring.mvcProject.dto.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {
	private DataSource dataFactory;	
	
	@Autowired
	public MemberDAO(DataSource dataSource) { //bean으로 등록한 dataSource 자동 주입
		try {
			this.dataFactory = dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	// 회원 정보 조회 메소드 (전체 회원 정보 SELECT 해서 반환)
	// MemberVO로 받아서 ArrayList에 저장 후 ArrayList 객체 memList 반환
	public ArrayList<MemberDTO> memberSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 데이터 저장해서 반환할 ArrayList 객체 생성
		ArrayList<MemberDTO> memList = new ArrayList<MemberDTO>();
		
		
		try {
			System.out.println("chekc");
			//connpool에서 con 객체 빌려옴
			con = dataFactory.getConnection();
			
			String sql = "select * from member2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 한 행(1명) 처리
				String memId = rs.getString("memId"); // 순서 번호 1, 2, 3... 사용해도 되고, 열 이름 사용해도 됨
				String memPwd = rs.getString("memPwd");
				String memName = rs.getString("memName");
				String memEmail = rs.getString("memEmail");
				Date memJoinDate = rs.getDate("memJoinDate");
				
				// MemberVO에 담아서
				MemberDTO vo = new MemberDTO();				
				vo.setMemId(memId);
				vo.setMemPwd(memPwd);
				vo.setMemName(memName);
				vo.setMemEmail(memEmail);
				vo.setMemJoinDate(memJoinDate);
				
				// ArrayList에 추가
				memList.add(vo);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				System.out.println("con"+con);
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {}
		}
		
		return memList; // ArrayList 반환
	}
}




