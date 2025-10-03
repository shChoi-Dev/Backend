$(document).ready(function(){
	// 'bookNoCheckBtn' 버튼 클릭 시 이벤트 처리
	$('#bookNoCheckBtn').on('click', function(){
		event.preventDefault();
		
		// bookNo 입력 필드의 값을 가져옴
		let bookNo = $('#bookNo').val();
	
		if(bookNo == ""){
			alert("도서번호를 입력하세요");
			return false;
		}else{ 
			$.ajax({
				type:"post",
				url:"/book/bookNoCheck", // BookController의 URL로 변경
				data:{"bookNo":bookNo},      // 전송할 데이터의 key를 'bookNo'로 변경
				dataType:"text",
				success:function(result){
					if(result=="available"){
						alert("사용가능한 번호 입니다.");
					}else {
						alert("사용 불가능한 번호 입니다.");
					}
				},
				error:function(data, textStatus){
					alert("전송실패");
				}
			});
		}
	});
});