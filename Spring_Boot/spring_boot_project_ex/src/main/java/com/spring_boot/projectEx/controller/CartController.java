package com.spring_boot.projectEx.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.projectEx.model.CartVO;
import com.spring_boot.projectEx.model.MemberVO;
import com.spring_boot.projectEx.model.OrderInfoVO;
import com.spring_boot.projectEx.service.CartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	// 장바구니 버튼 클릭 요청에 대한 처리
	@PostMapping("/product/insertCart")
	public String insertCart(CartVO vo, HttpSession session) {
		String memId = (String)session.getAttribute("sid"); // 로그인 된 상태에서만 요청이 가능하므로 세션변수 sid가 저장되어 있어야 함
		vo.setMemId(memId);
		
		// 장바구니에 상품을 추가하기 위한 로직
		// 1. 기존 장바구니에 동일 상품 있는지 확인
		int count = cartService.checkPrdInCart(vo.getPrdNo(), memId);
		
		if(count==0) {
			cartService.insertCart(vo);
		} else {
			cartService.updateQtyInCart(vo);
		}
		
		// 장바구니 목록 출력
		return "redirect:/product/cartListView";
	}
	
	// 로그인된 회원이 요청한 장바구니 목록 보기 요청 처리
	@RequestMapping("/product/cartListView")
	public String cartList(HttpSession session, Model model) {
		String memId = (String)session.getAttribute("sid"); // 요청을 한 회원 id
		ArrayList<CartVO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		
		return "product/cartListView";
	}
	
	// 장바구니 목록 삭제 -> 파라미터로 배열전달 ArrayList에 받아서 서비스로 전달
	@ResponseBody
	@PostMapping("/product/deleteCart")
	public int deleteCart(@RequestParam("chkbox") ArrayList<String> chkArr) {
		int result=0;
		
		// 서비스에 ArrayList 전달
		if(chkArr != null) {
			cartService.deleteCart(chkArr);
			result=1;
		}
		
		return result;
	}
	
	//// ==================================================================== ////
	//// 주문 처리 ////
	// 주문서 작성 요청 처리 - 카트 목록보기에서 요청 발생
	@PostMapping("/product/orderForm")
	public String orderForm(@RequestParam int[] cartNo,
							@RequestParam int[] cartQty,
						    Model model, 
						    HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		// (1) 주문하기 버튼 클릭 주문수량 변경되었을 수 있으므로 cart 테이블 주문수량 update 수행
		for(int i=0; i<cartNo.length; i++) {
			CartVO vo= new CartVO();
			vo.setCartNo(cartNo[i]);
			vo.setCartQty(cartQty[i]);
			cartService.updateCart(vo); // 카트 목록 한개마다 update 진행
		}
		
		// (2) 주문서에 출력할 회원 정보 추출
		MemberVO memVo = cartService.getMemberInfo(memId);
		model.addAttribute("memVo",memVo);
		// 핸드폰 data 분리
		String[] hp = (memVo.getMemHP()).split("-");
		model.addAttribute("hp1",hp[0]);
		model.addAttribute("hp2",hp[1]);
		model.addAttribute("hp3",hp[2]);
		
		// (3) 주문서에 출력할 주문할 장바구니 목록 추출
		ArrayList<CartVO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		return "product/orderForm";
		
	}
	
	// 주문 완료 요청
	@PostMapping("/product/orderComplete")
	public String orderInsert(OrderInfoVO ordInfoVo,
							  @RequestParam String hp1,
							  @RequestParam String hp2,
							  @RequestParam String hp3) {
	
		// 전화번호 설정
		String hp = hp1 + "-" + hp2 + "-" + hp3;
		ordInfoVo.setOrdRcvPhone(hp);
		
		// 주문번호 생성
		// 주문번호 : 오늘날짜시분초_랜덤숫자4개
		long timeNum = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmss");
		String strTime = dayTime.format(new Date(timeNum));
	
		// 랜덤숫자 4개
		String rNum="";
		for(int i=1; i<4; i++) {
			rNum += (int)(Math.random()*10);
		}
	
		String ordNo = strTime + "_" + rNum;
		// 주문번호 저장
		ordInfoVo.setOrdNo(ordNo);
		
		// service method 호출
		// ordInfoVo에는 수령인 정보와 주문자 정보가 저장되어 있음
		// 주문상품에 관한 정보는 cart테이블에서 추출해서 사용할 예정
		cartService.insertOrderInfo(ordInfoVo);
		
		return "product/orderCompleteView";
	}
	
	// (추가) 주문 내역 조회
    @GetMapping("/product/myOrder")
    public String myOrder(HttpSession session, Model model) {
        String memId = (String) session.getAttribute("sid");
        
        // 서비스를 통해 해당 회원의 주문 정보 목록을 가져옴
        ArrayList<OrderInfoVO> orderList = cartService.orderList(memId);
        
        model.addAttribute("orderList", orderList);
        
        return "product/myOrderListView"; // 뷰 페이지로 전달
    }
}
