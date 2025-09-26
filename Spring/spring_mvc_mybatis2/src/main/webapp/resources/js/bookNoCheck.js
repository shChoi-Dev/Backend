$(document).ready(function(){
	$('#bookNoCheckBtn').on('click', function(){
		event.preventDefault();
		
		let bookNo = $('#bookNo').val();
	
		if(bookNo == ""){
			alert("도서번호를 입력하세요.");
			return false;
		}else{ //서버측에 도서번호 중복 확인 요청
			$.ajax({
				type:"post",
				url:"/book/book/bookNoCheck",
				data:{"bookNo":bookNo},
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
	
	}); // on 종료
}); // ready 종료