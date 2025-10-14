/**
 * ID 중복조회
 */
 
$(document).ready(function() {

	$('#idCheck').click(function(){
		event.preventDefault();
  	
  		let memId = $('#memId').val();
  		
  		if (memId==""){
  			 alert("ID를 입력하세요");
  		} else {
	 	$.ajax({
 			type:"post",
 			url:"/member/idCheck", 
 			data : {"id":$('#memId').val()}, /* 컨트롤러에서 받는 이름 id  */
 			dataType:'text', /* 요청하는 데이터 타입 (반환 타입) */
 			success:function(result) {
 				if(result >0 ) {
 					alert("사용할 수 없는 ID 입니다"); 					
 				} else {
 					alert("사용 가능한 ID 입니다.");
 				}
 			},
 			error:function() {
 				alert("실패");
 			}
 		}); //ajax 끝
 		
 		} //else끝		
 	});
});

