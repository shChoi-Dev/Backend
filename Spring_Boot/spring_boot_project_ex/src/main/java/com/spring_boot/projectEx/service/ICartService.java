package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_boot.projectEx.model.CartVO;
import com.spring_boot.projectEx.model.MemberVO;
import com.spring_boot.projectEx.model.OrderInfoVO;

public interface ICartService {
	// 장바구니 및 주문관련 작업 처리시 필요한 메소드들
	// 장바구니 추가
	public void insertCart(CartVO vo);
	// 장바구니 동일상품 존재 여부 확인 메소드 : 동일 상품 수 : 파라미터 (상품번호)
	public int checkPrdInCart(String prdNo, String memId);
	// 동일상품 존재 시 수량 변경 메소드
	public void updateQtyInCart(CartVO vo);
	
	// 특정 회원의 카트 리스트
	public ArrayList<CartVO> cartList(String memId);
	// 장바구니 상품 삭제
	public void deleteCart(ArrayList<String> chkArr);
	
	// 주문 처리 작업에 필요한 추상 메소드
	public void updateCart(CartVO vo); // 주문 전 장바구니 수정했을 경우를 위한 메소드
	public MemberVO getMemberInfo(String memId);
	public void insertOrderInfo(OrderInfoVO ordInfoVo);
	public void insertOrderProduct(HashMap<String, Object> map);
	public void deleteCartAfterOrder(String memId);
	
	// (추가) 주문 내역 조회
	ArrayList<OrderInfoVO> orderList(String memId);
}
