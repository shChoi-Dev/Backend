/**
 * productDetail.js
 */
 
 window.onload = function() {
 	let qty = 1;
 	
 	let plusBtn = document.getElementById('plusBtn');
 	let minusBtn = document.getElementById('minusBtn');
 	
 	plusBtn.addEventListener('click', () => {
 		qtyChange(1); 	
 	});
 	
 	minusBtn.addEventListener('click', () => {
 		qtyChange(-1); 	
 	});
 	
 	// 주문수량 변경하는 함수
 	function qtyChange(num) {
 		qty = qty + num;
 		if(qty < 1) qty = 1;
 		
 		// 주문액 계산하는 함수 호출
 		calAmount();
 	}
 	
 	// 주문수량 변경될 때 주문액 계산해서 출력하는 함수
 	function calAmount(){
 		// 현재 주문수량과 구매예정금액 찾아오기
 		let cartQty = document.getElementById('cartQty');
 		let amount = document.getElementById('amount');
 		
 		// 상품 가격 알아오기 : <span> 태그이 data-price 속성 값 가져오기
 		let price = document.getElementById('price').dataset.price;
 		
 		let total = qty * price;
 		
 		// 결과값 태그에 출력
 		cartQty.value = qty;
 		amount.innerHTML = total.toLocaleString(); // 천단위 구분
 	}
 };
 
 
 
 
 
 
 
 
 
 
 
 
 