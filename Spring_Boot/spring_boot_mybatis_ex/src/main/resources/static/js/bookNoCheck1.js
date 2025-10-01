$(document).ready(function(){
	$('#bookNoCheckBtn').on('click', function(){
		event.preventDefault();
		
		let bookNo = $('#bookNo').val();
	
		if(bookNo == ""){
			alert("도서번호를 입력하세요");
			return false;
		}else{
			$.ajax({
				type:"get",
				url:"/book/book/bookNoCheck1/" + bookNo, // BookController의 URL로 변경
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