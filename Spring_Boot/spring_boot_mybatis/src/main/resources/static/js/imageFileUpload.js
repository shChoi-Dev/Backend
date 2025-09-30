$(document).ready(function(){
	$('#imageFileFrm').on('submit',function(){
		event.preventDefault(); // submit 이벤트 중지
		
		let formData = new FormData($('#imageFileFrm')[0]);
		
		let fileName = $('#uploadFile').val().split("\\").pop(); // 파일명만 추출() -> 이미지 출력
		
		// 서버에 요청 후 결과 받아서 브라우저에서 처리
		$.ajax({
			type:"post",			// 요청 방식 메소드
			url:"/imageFileUpload",	// 요청 url
			enctype:"multipart/form-data",
			processData:false,
			contentType:false,
			data: formData, // 요청시 전송될 파라미터
			success:function(result){
				if(result == "success") {
					// imageBox에 이미지를 출력
					$('#imageBox').html('<img src="/images/' + fileName + '"width="400" height="300">');
					}
				else
					alert("파일 업로드 실패");
			},
			error:function(data){
				alert("업로드 요청 실패");
			},
			complete:function(){
				//alert("작업 완료");
			}
		});
		
	}); // submit 종료
}); //ready 종료