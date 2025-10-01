$(document).ready(function(){
	$('#bookNoCheckBtn').on('click', function(){
		event.preventDefault();
		
		let bookNo = $('#bookNo').val();
	
		if(bookNo == ""){
			alert("도서번호를 입력하세요.");
			return false;
		}else{
			let data = {"bookNo":bookNo}; // 전송할 데이터의 key를 'bookNo'로 변경
			axios.post("/book/book/bookNoCheck5", data) // BookController의 URL로 변경
			.then(function(response){
				if(response.data=="available"){
					alert("사용가능한 번호 입니다.");
				}else {
					alert("사용 불가능한 번호 입니다.");
				}
			})
			.catch(err=>console.log(err));
		}
	});
});