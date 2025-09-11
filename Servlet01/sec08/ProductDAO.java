package sec08;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "SQL_USER"; // product.sql을 실행한 DB 계정
            String pwd = "1234";      // DB 계정 비밀번호
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
	
	 // 전체 상품 목록을 조회하는 메소드
    public ArrayList<ProductVO> productSelect() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<ProductVO> prdList = new ArrayList<>();

        try {
            con = getConnection();
            String query = "SELECT * FROM product";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductVO vo = new ProductVO();
                // ResultSet에서 데이터를 가져와 VO 객체에 저장
                vo.setPrdNo(rs.getString("PRDNO"));
                vo.setPrdName(rs.getString("PRDNAME"));
                vo.setPrdPrice(rs.getInt("PRDPRICE"));
                vo.setPrdMaker(rs.getString("PRDMAKER"));
                vo.setPrdColor(rs.getString("PRDCOLOR"));
                vo.setCtgNo(rs.getInt("CTGNO"));
                
                prdList.add(vo); // 리스트에 VO 추가
            }
        } catch (Exception e) {
            System.out.println("상품 조회 중 오류 발생");
            e.printStackTrace();
        } finally {
            // 자원 해제
            try {
                rs.close();
                pstmt.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prdList;
    }
}
