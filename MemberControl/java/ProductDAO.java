
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ProductDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 상품 리스트
	public ArrayList<ProductVO> productSelect() {
		ArrayList<ProductVO> prdList = new ArrayList<>();

		try {
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM product";
			pstmt = conn.prepareStatement(query);
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
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prdList;
	}

	public void addProduct(ProductVO vo) {
		try {
			conn = dataFactory.getConnection();
			String query = "INSERT INTO product (prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPrdNo());
			pstmt.setString(2, vo.getPrdName());
			pstmt.setInt(3, vo.getPrdPrice());
			pstmt.setString(4, vo.getPrdMaker());
			pstmt.setString(5, vo.getPrdColor());
			pstmt.setInt(6, vo.getCtgNo());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delProduct(String prdNo) {
		try {
			conn = dataFactory.getConnection();
			String query = "DELETE FROM product WHERE prdNo=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, prdNo);
			pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 특정 상품 정보 조회
	public ProductVO findProduct(String _prdNo) {
		ProductVO prdInfo = null;
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT * FROM product WHERE prdNo=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, _prdNo);
			ResultSet rs = pstmt.executeQuery();
			rs.next();

			String prdNo = rs.getString("prdNo");
			String prdName = rs.getString("prdName");
			int prdPrice = rs.getInt("prdPrice");
			String prdMaker = rs.getString("prdMaker");
			String prdColor = rs.getString("prdColor");
			int ctgNo = rs.getInt("ctgNo");

			prdInfo = new ProductVO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prdInfo;
	}

	// 상품 정보 수정
	public void modProduct(ProductVO vo) {
		try {
			conn = dataFactory.getConnection();
			String query = "UPDATE product SET prdName=?, prdPrice=?, prdMaker=?, prdColor=?, ctgNo=? WHERE prdNo=?";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, vo.getPrdName());
			pstmt.setInt(2, vo.getPrdPrice());
			pstmt.setString(3, vo.getPrdMaker());
			pstmt.setString(4, vo.getPrdColor());
			pstmt.setInt(5, vo.getCtgNo());
			pstmt.setString(6, vo.getPrdNo());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
