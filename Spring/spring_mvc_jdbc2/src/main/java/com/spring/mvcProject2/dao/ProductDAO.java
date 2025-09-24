package com.spring.mvcProject2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.spring.mvcProject2.dto.ProductDTO;

@Repository
public class ProductDAO {
	private DataSource dataFactory;

	public ProductDAO(DataSource dataSource) { //bean으로 등록한 dataSource 자동 주입
		try {
			this.dataFactory = dataSource;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 상품 리스트
	public ArrayList<ProductDTO> productSelect() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 데이터 저장해서 반환할 ArrayList 객체 생성
		ArrayList<ProductDTO> prdList = new ArrayList<>();

		try {
			con = dataFactory.getConnection();
			
			String query = "SELECT * FROM product";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ProductDTO vo = new ProductDTO();
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
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return prdList;
	}
}
