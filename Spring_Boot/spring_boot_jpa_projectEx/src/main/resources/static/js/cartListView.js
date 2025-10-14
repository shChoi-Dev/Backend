/**
 * cartListView.js
 */
   $(document).ready(function() {
   
   		// [전체 선택] 체크박스 체크했을 때
   		$('#allCheck').on('click', function() {
   			let chk = $('#allCheck').prop("checked"); // 체크 여부 확인
   			
   			// 체크 되었다면 (true) : 모든 개별 체크박스를 true로 설정
   			if(chk) {
   				$('.chkDelete').prop("checked", true);
   			} else {
   				$('.chkDelete').prop("checked", false);
   			}
   		});
   		
   		// 개별 체크박스 해제할 경우 [전체 선택] 체크박스 해제
   		//[전체 선택] 체크박스 체크했을때
	 	$('.chkDelete').on('click', function(){
	 		let total = $('.chkDelete').length; // 개별 체크박스의 전체 개수
	 		let checked = $('.chkDelete:checked').length; // 체크된 체크박스 개수
	 		
	 		if( total != checked){ // 같지 않다면(모두 선택된 상태가 아니라면)
	 			$('#allCheck').prop("checked", false); // 해제
	 		}else{
	 			$('#allCheck').prop("checked", true); // 체크
	 		}
	 	});
	 	
	 	// [삭제] 버튼 클릭했을 때 선택된 상품을 장바구니에서 삭제	 	
	 	$('#deleteCartBtn').on('click', function() {
	 		// 체크 여부 확인 : 하나라도 체크하면 true, 아무 것도 체크하지 않으면 false
	 		let checked = $('.chkDelete').is(':checked');
	 		
	 		if(checked) {
	 			let answer = confirm("선택된 상품을 삭제하시겠습니까?");
	 			if(answer) {
	 				// 체크된 체크박스의 carNo를 배열에 추가
	 				let checkArr = new Array();
	 				$('.chkDelete:checked').each(function() {
	 					checkArr.push($(this).val()); //<input type="hidden" name="cartNo" value="${prd.cartNo}">
	 				});	
 				
 					// 서버로 전송
 					$.ajax({
 						type:"post",
			 			url:"/product/deleteCart", 
			 			data : {"chkbox":checkArr}, /* 컨트롤러에서 받는 이름 chkbox  */
			 			dataType:'text', /* 요청하는 데이터 타입 (반환 타입) */
			 			success:function(result) {
			 				if(result == 1) {				 					
			 					location.href= "/product/cartList";
			 				}
			 			},
			 			error:function() {
			 				alert("실패");
			 			} 	 					
	 				}); // ajax 종료
		 			
		 		} // answer 끝
		 		
	 		} else { // 체크박스 하나라도 선택하지 않은 경우
	 			alert("선택된 상품이 없습니다");
	 		}
	 		
	 	});	// deleteCartBtn  click 끝 	
	 	
	 	///////////////////////////////////////////////////////////	 
	 	
	 	// 주문수량 변경 처리
	 	let amount = $('.amount');
	 	let price = $('.price');
	 	let sum = 0;
	 	
	 	// 주문수량 수정 시
	 	$.each($('.cartQty'), function(i){
	 		$(this).on('keyup', function(){
	 			let qty = $(this).val();   
	 			amount[i].dataset.amount = (price[i].dataset.price * qty); // 가격 value
	 			amount[i].innerHTML = (price[i].dataset.price * qty).toLocaleString(); // 표시 (천단위)
	 			// sum 구하는 함수 호출
	 			sumAmount();
	 			
	 			// 총구매예정금액 출력
	 			$('#total').text(sum.toLocaleString());	 			
	 		});
	 	});
	 	
	 	// sum 계산하는 함수
	 	function sumAmount(){
	 		sum = 0;
	 		$('.amount').each(function(){
	 			sum += Number($(this).attr("data-amount"));
	 		});
	 	}
	 	
	 	
   }); // ready 끝
   
   
   
   
   
   
   
   
   
   