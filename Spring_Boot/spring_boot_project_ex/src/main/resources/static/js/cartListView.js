/* 전체선택 체크박스 기능 추가

*/

$(document).ready(function(){
	// 주문수량 변경 처리
	let amount = $('.amount') // 총 구매 예정 금액
	let price = $('.price') // 상품 가격
	let sum = 0;
	
	$.each($('.cartQty'),function(i){
		$(this).on('keyup', function(index){
			let qty = $(this).val();
			amount[i].dataset.amount = (price[i].dataset.price * qty); // span 태그 속성 변경
			amount[i].innerHTML = (price[i].dataset.price * qty).toLocaleString(); // span 태그 내부 text 변경
			sumAmount(); // 총 구매예정 금액 계산
			$('#total').text(sum.toLocaleString());
		})
	})
	
	function sumAmount(){
		$('.amount').each(function(){
			sum+=Number($(this).attr("data-amount"))
		});
	}
	
	// [전체 선택] 체크박스 체크 했을 떄
	$('#allCheck').on('click', function(){
		let chk = $('#allCheck').prop("checked");
		
		//chk가 true면 : 체크되어 있으면
		if(chk){
			$('.chkDelete').prop("checked", true);
		}else { //전체선택 체크되어 있지 않음
			$('.chkDelete').prop("checked", false);
		}
		
	}); // 전체 선택 click 끝 
	
	// 개별 체크박스의 해제 또는 체크에 따른 전체선택 체크박스 변경
	$('.chkDelete').on('click', function(){
		let total = $('.chkDelete').length; // 개별 체크박스 전체 개수
		let checked = $('.chkDelete:checked').length; // 체크된 체크박스 개수
		
		if(total != checked)
			$('#allCheck').prop("checked",false); //해제
		else
			$('#allCheck').prop("checked",true); //체크
		
	}); //개별 선택 click
	
	// 삭제 버튼 클릭했을 때 장바구니에서 선택된 상품 삭제
	$('#deleteCartBtn').on('click',function(){
		 let checked = $('.chkDelete').is(':checked'); // 선택여부 반환(여러 체크박스 중 한개라도 체크되어 있으면 true, 아니면 false)
		
		if(checked){// 하나라도 체크된 경우
			let answer = confirm("선택된 상품을 삭제하시겠습니까?");
			
			if(answer){
				// 체크된 상품의 cartNo 배열로 구성
				let checkArr = new Array();
				$('.chkDelete:checked').each(function(){
					checkArr.push($(this).val()); // 체크박스의 value 속성 값으로 cartNo가 표현되어 있음
				}); // each 끝
				
				$.ajax({
					type:"post",
					url:"/product/deleteCart",
					data:{"chkbox":checkArr},
					dataType:"text",
					success:function(result){
						if(result==1){
							location.href = "/product/cartListView";
						}
					},
					error:function(){
						alert("요청 실패");
					}
					
				}); //ajax 끝
				
			} // answer 끝
			
		} //checked 끝
		
	}); // 삭제버튼 클릭 종료
	
});