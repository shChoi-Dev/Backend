/**
 * bookSearch2.js
 * [검색 방법 2] : Controller의 View 반환 메소드를 호출
 * 서버로부터 완성된 HTML 조각(JSP 렌더링 결과)을 받아와 화면에 그대로 삽입
 */
$(document).ready(function(){
	$('#bookSearchFrm2').on('submit',function(){
		event.preventDefault();
		
		let formData = $(this).serialize();
		
		let keyword=$('#keyword').val();
		let type=$('#type').val();
		
		if(keyword==""||type==""){
			alert("검색 조건과 검색어를 입력하세요");
			//return false;
		}else{
			$.ajax({
				type:"post",			
				url:"/book/bookSearch2",	// BookController의 bookSearch2() 메소드 호출
				data: formData,			
				// dataType을 지정하지 않으면 jQuery가 응답 타입을 자동으로 판단 (여기서는 HTML)
				success:function(result){
					console.log(result);
					// 서버로부터 받은 HTML 결과를 #searchResultBox에 그대로 삽입
					$('#searchResultBox').html(result);

				},
				error:function(data){
					alert("요청 실패");
				}
			});
		}
	}); // submit 종료
}); //ready 종료
