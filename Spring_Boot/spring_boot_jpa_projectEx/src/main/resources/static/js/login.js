/**
 * login.js
 */
  $(document).ready(function() {
  	$('#loginForm').on('submit', function() {
  		event.preventDefault();
  	
	 	$.ajax({
 			type:"post",
 			url:"/member/login", 
 			data : {"id":$('#id').val(),
 						"pwd": $('#pwd').val()}, /* 컨트롤러에서 받는 이름 id, pwd  */
 			dataType:'text', /* 요청하는 데이터 타입 (반환 타입) */
 			success:function(result) {
 				if(result == "success") {
 					alert("로그인 성공\n홈으로 이동");
 					location.href= "/";
 				} else {
 					alert("아이디 또는 비밀번호가 일치하지 않습니다");
 				}
 			},
 			error:function() {
 				alert("실패");
 			}
 		}); 		
 	});
});