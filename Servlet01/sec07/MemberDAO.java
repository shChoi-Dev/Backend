package sec07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Date;

public class MemberDAO {
	
	private Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SQL_USER";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url,user,pwd);
			
			if (con != null) {
				System.out.println("DB 연결 성공");
			}
			
		}catch(Exception e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return con;
	}
	
	// 전체 회원 정보 반환 : select
	public ArrayList<MemberVO> memberSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			con = getConnection();
			String query = "select * from member";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemID(rs.getString("memId"));
				vo.setMemPWD(rs.getString("memPwd"));
				vo.setMemName(rs.getString("memName"));
				vo.setMemEmail(rs.getString("memEmail"));
				vo.setMemJoinDate(rs.getDate("memJoinDate"));
				
				memList.add(vo);
			}
			
		}catch(Exception e) {
			System.out.println("회원 조회 실패");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return memList;
	}
	
	
}
